import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int p,m;
    public static Map<String, Integer> users = new LinkedHashMap<>();
    public static Map<String, List<String>> rooms = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            users.put(name, level);
        }

        for (String name : users.keySet()) {
            int flag = 0;
            int userLevel = users.get(name);
            for (String leader : rooms.keySet()) {
                if ((users.get(leader) >= userLevel - 10 && users.get(leader) <= userLevel + 10) && rooms.get(leader).size() < m) {
                    rooms.get(leader).add(name);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                rooms.put(name, new ArrayList<>());
                rooms.get(name).add(name);
            }
        }

        for (String leader : rooms.keySet()) {
            if (rooms.get(leader).size() >= m) {
                System.out.println("Started!");
                List<String> members = rooms.get(leader);
                Collections.sort(members);
                for (String user : members) {
                    System.out.println(users.get(user) + " " + user);
                }
            }
            else {
                System.out.println("Waiting!");
                List<String> members = rooms.get(leader);
                Collections.sort(members);
                for (String user : members) {
                    System.out.println(users.get(user) + " " + user);
                }
            }
        }


    }

}
