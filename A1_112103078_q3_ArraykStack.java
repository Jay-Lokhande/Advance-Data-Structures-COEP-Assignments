public class A1_112103078_q3_ArraykStack {
        private int k; // Number of stacks
        private int n; // Total size of the array
        public static int[] array; // The array to hold the elements
        public static int[] tops; // Array to store top indices for each stack
        public static int[] next; // Array to store next available index

        // Constructor to initialize k stacks in the array
        public A1_112103078_q3_ArraykStack(int k, int n) {
            this.k = k;
            this.n = n;
            this.array = new int[n];
            this.tops = new int[k];
            this.next = new int[n];

            // Initialize tops for each stack
            for (int i = 0; i < k; i++) {
                tops[i] = -1;
            }

            // Initialize next to link all the elements in the array
            for (int i = 0; i < n - 1; i++) {
                next[i] = i + 1;
            }
            next[n - 1] = -1; // -1 indicates the end of the array
        }

        // Push an element onto the specified stack
        public void push(int stackNumber, int data) {
            if (stackNumber < 0 || stackNumber >= k) {
                System.out.println("Invalid stack number");
                return; // or throw an exception
            }

            int freeIndex = getNextFreeIndex();
            if (freeIndex == -1) {
                System.out.println("Stack overflow");
                return; // or throw an exception
            }

            array[freeIndex] = data;
            next[freeIndex] = tops[stackNumber];
            tops[stackNumber] = freeIndex;

            System.out.println(data + " pushed to Stack " + stackNumber);
        }

        // Pop an element from the specified stack
        public int pop(int stackNumber) {
            if (stackNumber < 0 || stackNumber >= k) {
                System.out.println("Invalid stack number");
                return -1; // or throw an exception
            }

            if (tops[stackNumber] == -1) {
                System.out.println("Stack " + stackNumber + " is empty");
                return -1; // or throw an exception
            }

            int poppedIndex = tops[stackNumber];
            int poppedValue = array[poppedIndex];

            tops[stackNumber] = next[poppedIndex];
            next[poppedIndex] = getFreeIndex();

            return poppedValue;
        }

        // Get the next available index in the array
        private int getNextFreeIndex() {
            int freeIndex = next[0];
            next[0] = next[freeIndex];
            return freeIndex;
        }

        // Get a free index and link it to the next free index
        private int getFreeIndex() {
            int freeIndex = next[0];
            next[0] = freeIndex;
            return freeIndex;
        }

        // Display the elements of all stacks
        public void display() {
            for (int i = 0; i < k; i++) {
                System.out.print("Stack " + i + ": ");
                int current = tops[i];
                while (current != -1) {
                    System.out.print(array[current] + " ");
                    current = next[current];
                }
                System.out.println();
            }
        }
        public static void print(int arr[]) {
            for (int ele : arr) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

        public static void main(String[] args) {
            int k = 3; // Number of stacks
            int n = 9; // Total size of the array
            A1_112103078_q3_ArraykStack kStacks = new A1_112103078_q3_ArraykStack(k, n);
            System.out.print("array : ");
            print(array);
            System.out.print("tops : ");
            print(tops);
            System.out.print("next : ");
            print(next);

            kStacks.push(0, 10);
            kStacks.push(1, 20);
            kStacks.push(2, 30);
            kStacks.push(0, 40);
            kStacks.push(1, 50);
            kStacks.push(1, 60);
            System.out.print("array : ");
            print(array);
            System.out.print("tops : ");
            print(tops);
            System.out.print("next : ");
            print(next);

            kStacks.display();

            System.out.println("Popped from Stack 0: " + kStacks.pop(0));
            System.out.println("Popped from Stack 1: " + kStacks.pop(1));

            kStacks.display();
            System.out.print("array : ");
            print(array);
            System.out.print("tops : ");
            print(tops);
            System.out.print("next : ");
            print(next);
        }

}
