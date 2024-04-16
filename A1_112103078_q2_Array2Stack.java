public class A1_112103078_q2_Array2Stack {
        private int maxSize;
        private int[] array;
        private int top1, top2;

        public A1_112103078_q2_Array2Stack(int size) {
            this.maxSize = size;
            this.array = new int[size];
            this.top1 = -1;
            this.top2 = size;
        }

        // Push an element onto the first stack
        public void push1(int data) {
            if (top1 < top2 - 1) {
                array[++top1] = data;
                System.out.println(data + " pushed to Stack 1");
            } else {
                System.out.println("Stack 1 overflow");
            }
        }

        // Push an element onto the second stack
        public void push2(int data) {
            if (top1 < top2 - 1) {
                array[--top2] = data;
                System.out.println(data + " pushed to Stack 2");
            } else {
                System.out.println("Stack 2 overflow");
            }
        }

        // Pop an element from the first stack
        public int pop1() {
            if (top1 >= 0) {
                return array[top1--];
            } else {
                System.out.println("Stack 1 is empty");
                return -1; // or throw an exception
            }
        }

        // Pop an element from the second stack
        public int pop2() {
            if (top2 < maxSize) {
                return array[top2++];
            } else {
                System.out.println("Stack 2 is empty");
                return -1; // or throw an exception
            }
        }

        // Display the elements of both stacks
        public void display() {
            System.out.print("Stack 1: ");
            for (int i = 0; i <= top1; i++) {
                System.out.print(array[i] + " ");
            }

            System.out.print("\nStack 2: ");
            for (int i = maxSize - 1; i >= top2; i--) {
                System.out.print(array[i] + " ");
            }

            System.out.println();
        }

        public static void main(String[] args) {
            A1_112103078_q2_Array2Stack twoStacks = new A1_112103078_q2_Array2Stack(6);

            twoStacks.push1(10);
            twoStacks.push2(20);
            twoStacks.push1(30);
            twoStacks.push2(40);

            twoStacks.display();

            System.out.println("Popped from Stack 1: " + twoStacks.pop1());
            System.out.println("Popped from Stack 2: " + twoStacks.pop2());

            twoStacks.display();
        }


    }


