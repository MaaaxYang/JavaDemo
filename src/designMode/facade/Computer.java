package designMode.facade;

/**
 * Created by Administrator on 2017/12/20.
 */
public class Computer {
    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer(){
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    public void startUp()
    {
        System.out.println("this's computer startUp start");
        cpu.startUp();
        memory.startUp();
        disk.startUp();
        System.out.println("this's computer startUp finished");
    }

    public void shutDown()
    {
        System.out.println("this's computer shutDown start");
        cpu.shutDown();
        memory.shutDown();
        disk.shutDown();
        System.out.println("this's computer shutDown finished");
    }
}
