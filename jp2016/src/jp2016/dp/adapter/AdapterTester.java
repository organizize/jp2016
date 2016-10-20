package jp2016.dp.adapter;

import itaphones.phone.*;

public class AdapterTester {

    public static void main(String[] args) {

        MobilePhoneAdapter mobAdapter = new MobilePhoneAdapter(new MobilePhone());
        System.out.println(AutomaticDialer.dial(mobAdapter));
    }

}

class MobilePhoneAdapter implements Phone {

    MobilePhone mob;
    String number;

    public MobilePhoneAdapter(MobilePhone mob) {
        this.mob = mob;
    }

    @Override
    public void dial(String number) {
        this.number = number;
    }

    @Override
    public String getReponse() {
        return mob.dial(number);
    }
}
