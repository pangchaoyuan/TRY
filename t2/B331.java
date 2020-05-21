import java.util.*;

public class B331{
    private static Map<Character,Integer> map = new HashMap<>();

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            String str = scan.nextLine(); //名字
            for(char a : str.toCharArray()){
               AddCandidate(a);
            }

              scan.nextInt();

            String str2 = scan.nextLine();
            for(char a : str2.toCharArray()){
                Vote(a);
            }
            for(char a :str.toCharArray()){
                GetVoteResult(a);
            }
            int sum = 0;
            for(int j :map.values()){
                sum+=j;
            }
            System.out.println("Invalid : "+sum);
        }

    }

    public static int AddCandidate(char pCandidateName){
        if(map.containsKey(pCandidateName)){
            return 0;
        }else{
            map.put(pCandidateName,0);
            return 1;
        }
    }

    public static void Vote(char pCandidateName){
        map.put(pCandidateName,map.get(pCandidateName)+1);

    }

    public static int GetVoteResult(char pCandidateName){
          if(map.containsKey(pCandidateName)){
              System.out.println(pCandidateName+" : "+map.get(pCandidateName));
              return map.get(pCandidateName);
          }else{
              return -1;
          }
    }

    public static void Clear(){
        map.clear();
    }
}