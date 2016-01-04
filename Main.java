public class Main {


    /*
                               A B C
                   _________/    |   \___________
                  /              |               \
               A B C           B A C            C B A
              /     \         /     \          /     \
           A B C   A C B   B A C   B C A    C B A   C A B

     */


    public static void main(String[] args) {
        int size = 3;
        int arr[] = new int[size];
        for(int i = 0; i < size; i++)
            arr[i] = i;

        // 시간 측정
        start = System.currentTimeMillis();
        perm(arr, 0);
        end = System.currentTimeMillis();
        System.out.println( "perm 실행 시간 : " + ( end - start )/1000.0 );
    }

    // arr 에서 a 와 b 위치의 원소를 서로 바꾸는 함수
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void perm(int[] arr, int depth) {

        // 트리에서 한개의 리프 노드에 다다르고 출력
        if (depth == arr.length) {
            print(arr);
            return;
        }

        // 현재 깊이에서 문자열 종주
        for (int i = depth; i < arr.length; i++) {
            swap(arr, i, depth); // 바꾸고
            perm(arr, depth + 1); // 자식으로 이동하고
            swap(arr, i, depth); // 돌아와서 다시 바꾸고
        }

    }

    // 배열 내용 출력 함수
    public static void print(int arr[]){
        for(int i = 0; i < arr.length; i ++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}


