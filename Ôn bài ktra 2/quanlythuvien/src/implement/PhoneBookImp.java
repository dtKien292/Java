package implement;

import Interface.IPhoneBook;
import model.IntlPhoneNumber;
import model.PhoneNumber;
import exception.VaildException;

import java.util.*;

public class PhoneBookImp implements IPhoneBook {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<PhoneNumber> listPN = new ArrayList<>();
    private ArrayList<IntlPhoneNumber> listIPN = new ArrayList<>();
    public PhoneBookImp() {

    }

    @Override
    public void themSDT() {
        System.out.println("So dt ban muon them?");
        System.out.println("1. Trong nuoc"+"\t"+"2. Quoc te"+"\t"+"0. Dung nhap");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 0->{
                System.out.println("Da thoat");
            }
            case 1->{
                String sdt;
                String re = "\\d{3,4}-\\d{6,7}";
                while (true){
                    try {
                        System.out.println("Nhap so dt: ");
                        sdt = sc.nextLine();
                        if (sdt.matches(re) && sdt.length()==11){
                            break;
                        } else {
                            throw new VaildException("SDT khong dung dinh dang");
                        }
                    }catch (VaildException e){
                        System.err.println(e);
                    }
                }
                String[] x = sdt.split("-");
                listPN.add(new PhoneNumber(x[0], x[1]));
            }
            case 2->{
                String sdt;
                String re = "\\d{2}-\\d{2,3}-\\d{6,7}";
                while (true){
                    try {
                        System.out.println("Nhap so dt: ");
                        sdt = sc.nextLine();
                        if (sdt.matches(re) && sdt.length()==13){
                            break;
                        } else {
                            throw new VaildException("SDT khong dung dinh dang");
                        }
                    }catch (VaildException e){
                        System.err.println(e);
                    }
                }
                String[] x = sdt.split("-");
                listIPN.add(new IntlPhoneNumber(x[0],x[1],x[2]));
            }
            default -> {
                System.out.println("Chon 0-2");
            }
        }
    }

    @Override
    public ArrayList<Object> timSDT() {
        ArrayList<Object> sdt = new ArrayList<>();
        System.out.println("Nhap ma vung ban muon tim: ");
        String maVung = sc.nextLine();
        for (PhoneNumber phoneNumber : listPN){
            if (Objects.equals(phoneNumber.getMaVung().substring(1), maVung)){
                sdt.add(phoneNumber);
            }
        }
        for (IntlPhoneNumber phoneNumber : listIPN){
            if (Objects.equals(phoneNumber.getMaVung(), maVung)){
                sdt.add(phoneNumber);
            }
        }
        return sdt;
    }

    @Override
    public ArrayList<Object> lietKeSDT() {
        ArrayList<Object> sdt = new ArrayList<>();
        for (PhoneNumber phoneNumber : listPN) sdt.add(phoneNumber);
        for (IntlPhoneNumber phoneNumber : listIPN) sdt.add(phoneNumber);
        return sdt;
    }

    @Override
    public Map<String, Integer> tongSDT() {
        Set<String> sdts = new HashSet<>();
        Map<String, Integer> maps = new HashMap<>();
        int count = 0;
        for (PhoneNumber phoneNumber : listPN){
            sdts.add(phoneNumber.getMaVung());
        }
        for (IntlPhoneNumber phoneNumber : listIPN){
            sdts.add(phoneNumber.getMaVung());
        }
        for (String sdt : sdts) {
            int dem = 0;
            for (PhoneNumber phoneNumber : listPN){
                if (Objects.equals(phoneNumber.getMaVung().substring(1), sdt)){
                    dem += 1;
                }
            }
            for (IntlPhoneNumber phoneNumber : listIPN){
                if (Objects.equals(phoneNumber.getMaVung(), sdt)){
                    dem += 1;
                }
            }
            maps.put(sdt,dem);
        }
        return maps;
    }

    @Override
    public ArrayList<Object> timTheoDuoi() {
        ArrayList<Object> sdtlasonhieu = new ArrayList<>();
        System.out.println("Nhap nhung so cuoi ban muon tim: ");
        String sdt = sc.nextLine();
        int n = sdt.length();
        for (PhoneNumber phoneNumber : listPN){
            if (Objects.equals(phoneNumber.getNoiVung().substring(phoneNumber.getNoiVung().length()-n), sdt)){
                sdtlasonhieu.add(phoneNumber);
            }
        }
        for (IntlPhoneNumber phoneNumber : listIPN){
            if (Objects.equals(phoneNumber.getNoiVung().substring(phoneNumber.getNoiVung().length()-n), sdt)){
                sdtlasonhieu.add(phoneNumber);
            }
        }
        return sdtlasonhieu;
    }

    @Override
    public ArrayList<Object> sapXepSDT() {
        ArrayList<Object> daSX = new ArrayList<>();
        for (PhoneNumber phoneNumber : listPN){
            daSX.add(phoneNumber);
        }
        for (IntlPhoneNumber phoneNumber : listIPN){
            daSX.add(phoneNumber);
        }
        Collections.sort(daSX, Collections.reverseOrder());
        return daSX;
    }
}
