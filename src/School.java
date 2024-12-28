import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Person> members;

    public School() {
        this.members = new ArrayList<>();
    }

    public void addMember(Person person) {
        members.add(person);
    }

    public List<Person> getMembers() {
        return members;
    }

    public void displayMembers() {
        for (Person member : members) {
            System.out.println(member.toString());
        }
    }
}