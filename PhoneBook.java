

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBook extends Phone {

    ArrayList<String> PhoneList = new ArrayList();

    @Override
    void insertPhone(String name, String phone) {
        boolean tim = false;
        for (String s : PhoneList) {
            if (s.contains(name)) {
                tim = true;
                if (!s.contains(phone)) {
                    s += " : " + phone;
                } else {
                    System.out.println("Danh bạ này đã có sẵn");
                }
            }
        }
        if (!tim) {
            PhoneList.add(name + "," + phone);
        }
    }

    @Override
    void removePhone(String name) {
        boolean tim = false;
        for (String s : PhoneList) {
            if (name.equals(s.substring(0, s.indexOf(",")))) {
                tim = true;
                PhoneList.remove(s);
                System.out.println("Đã xóa");
                break;
            }
        }
        if (!tim) System.out.println("Không thấy: " + name);
    }

    @Override
    void updatePhone(String name, String newPhone) {
        String s = name;
        s = s.substring(0, s.indexOf(","));
        PhoneList.set(PhoneList.indexOf(s), s + "," + newPhone);
        System.out.println("Đã cập nhật");
    }

    @Override
    void searchPhone(String name) {
        boolean searched = false;
        for (String s : PhoneList) {
            if (s.contains(name)) {
                searched = true;
                System.out.println(s.toString());
                break;
            }
        }
        if (!searched) System.out.println("Không có người");
    }

    @Override
    void sort() {
        if (PhoneList.size() == 0) System.out.println("Trống");
        else {

            Collections.sort(PhoneList, new Comparator<String>() {
                @Override
                public int compare(String s, String t1) {
                    return s.compareTo(t1);
                }
            });
            System.out.println("Xếp theo tên:");
            for (String s : PhoneList) {
                System.out.println(s);
            }

            Collections.sort(PhoneList, new Comparator<String>() {
                @Override
                public int compare(String s, String t1) {
                    return t1.compareTo(s);
                }
            });
            System.out.println("Xếp theo tên:");
            for (String s : PhoneList) {
                System.out.println(s);
            }
        }
    }
}
