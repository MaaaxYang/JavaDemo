package someTopics;

import javax.crypto.Mac;

public class SnowflakeIdWorkerDemo {
    private final long startToken =  1420041600000L;

    private final long serviceIdBit = 10l;

    private final long maxServiceId = -1 ^ -1l<<serviceIdBit;

    private final long sequenceBit = 12l;

    private final long serviceIdMoveLength = 12l;

    private final long timestampMoveLength = 12l+10l;

    private final long maxSequenceId = -1 ^ -1l<<serviceIdBit;

    private long serviceId;

    private long sequenceId = 0l;

    private long lastTimestamp = -1l;

    public SnowflakeIdWorkerDemo(long serviceId) {
        this.serviceId = serviceId;
    }

    public synchronized long nextId()
    {
        long timetamp = timeGen();
        if (timetamp<lastTimestamp){
            throw new RuntimeException("时间被回退");
        }

        if (timetamp == lastTimestamp){
            sequenceId = (sequenceId + 1) & maxSequenceId;
            if (sequenceId==0){
                timetamp = waitNextMillis(lastTimestamp);
            }
        }else {
            sequenceId =0l;
        }

        lastTimestamp = timetamp;

        return ((timetamp - startToken)<< timestampMoveLength) |
                (serviceId << serviceIdMoveLength) |
                (sequenceId);
    }

    public long waitNextMillis(long lastTimestamp){
        long timestamp = timeGen();
        while (lastTimestamp>= timestamp)
        {
            timestamp = timeGen();
        }
        return timestamp;
    }

    public long timeGen()
    {
        return System.currentTimeMillis();
    }

    public static void main(String[] args)
    {
        SnowflakeIdWorkerDemo demo = new SnowflakeIdWorkerDemo(1024);
        long start = System.currentTimeMillis();
        for (int i = 0 ;i<10;i++){
            long id = demo.nextId();
            System.out.println(id);
        }
        long end1 = System.currentTimeMillis() - start;
        System.out.println("耗时：" + end1 + "毫秒");
    }
}
