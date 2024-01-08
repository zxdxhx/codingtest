import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            String str = scan.nextLine();
            if(map.containsKey(str)){
                map.put(str, map.get(str)+1);
            }else{
                map.put(str, 1);
            }
        }

//        System.out.println("=======");
//        for(String key: map.keySet()){
//            System.out.println(key+" , "+map.get(key));
//        }

        int max = 0;
        String maxStr = "";
        for(String key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                maxStr = key;
            }else if(map.get(key) == max){
                if(key.compareTo(maxStr)<0)
                    maxStr = key;
            }
        }
        System.out.println(maxStr);

    }
}
