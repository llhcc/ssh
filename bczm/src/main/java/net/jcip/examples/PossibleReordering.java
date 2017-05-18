package net.jcip.examples;

/**
 * PossibleReordering
 * <p/>
 * Insufficiently synchronized program that can have surprising results
 *
 * @author Brian Goetz and Tim Peierls
 */
public class PossibleReordering {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(new Runnable() {
            public void run() {
                a = 1;
                x = b;
            }
        });
        Thread other = new Thread(new Runnable() {
            public void run() {
            	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
                b = 1;
                y = a;
            }
        });
        other.start();
        other.join();//线程other执行完成之后再往下执行
        one.start();
        one.join();//线程one执行完成之后再往下执行
        System.out.println("( " + x + "," + y + ")");
    }
}
