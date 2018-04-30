class DebuggingExercise4 {
    public static void main(String[] args) {
        Account a = new Account("Cake");
        a.deposit(100);
        System.out.println(a.getOwner() + " has $" + a.getBalance());
        a.withdraw(200);
        System.out.println("After trying to withdraw $200, " + a.getOwner() + " has $" + a.getBalance());
    }
}

/*
 * Where is the variable watch window on your screen?
 * > Bottom panel (below the code editor).
 *
 * What information does this present to you?
 * > args (String[])
 * > a (Account)
 * > - balance (double)
 * > - owner (String)
 * > - - value (char[])
 * > - - hash (int)
 *
 * Where is the method call stack on your screen?
 * > To the left of the variables
 *
 * What information does this describe?
 * > The active threads and the call stack.
 *
 * Step Over: What does this do?
 * > Goes to the next line in the block.
 *
 * Step Into: What does this do?
 * > Goes to the next line or into a user-(re)defined method.
 *
 * Step Out: What does this do?
 * > Completes and moves to to the point that called the method or merges to the main thread.
 *
 * Continue: What does this do?
 * > Runs the program from the debug point up to the end of the program or the next breakpoint.
 */