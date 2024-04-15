public class UnisexBathroomProblem {

    private Integer maxCount = 0;

    private Integer count = 0;

    private Gender inUse = Gender.NONE;

    private Object object = new Object();

    public UnisexBathroomProblem(Integer maxCount) {
        this.maxCount = maxCount;
    }

    public void useBathroom(Person p) throws InterruptedException {
        synchronized (object) {
            while ((inUse != Gender.NONE && p.getGender() != inUse) || count == maxCount) {
                System.out.println(p.getName() + " waiting for bathroom.");
                object.wait();
            }
            count++;
            inUse = p.getGender();
        }
        System.out.println(p.getName() + " using bathroom.\n" + "Bathroom in use by: " + inUse + "\nTotal persons in bathroom: " + count);
        Thread.sleep(3000);
        synchronized (object) {
            count--;
            if (count == 0) inUse = Gender.NONE;
            System.out.println(p.getName() + " left bathroom.");
            object.notifyAll();
        }
    }

}
