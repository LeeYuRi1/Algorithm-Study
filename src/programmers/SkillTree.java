package programmers;

// 스킬트리
public class SkillTree {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
        System.out.println(solution2("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] skillnum;
        for (int i = 0; i < skill_trees.length; i++) {
            skillnum = new int[skill.length()];
            boolean check = true;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                String s = skill_trees[i].charAt(j) + "";
                if (skill.contains(s)) {
                    int index = skill.indexOf(s);
                    skillnum[index]++;
                    for (int n = 0; n < index; n++) {
                        if (skillnum[n] == 0) {
                            check = false;
                            break;
                        }
                    }
                }
            }
            if (check) answer++;
        }
        return answer;
    }

    // 다른 풀이
    public static int solution2(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        for (int i = 0; i < skill_trees.length; i++) {
            String s = skill_trees[i].replaceAll("[^" + skill + "]", "");
            if (skill.indexOf(s) != 0) answer--;
        }
        return answer;
    }
}
