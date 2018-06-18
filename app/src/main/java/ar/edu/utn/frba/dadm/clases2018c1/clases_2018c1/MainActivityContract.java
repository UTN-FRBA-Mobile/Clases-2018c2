package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

public interface MainActivityContract {
    interface View{
        void initView(String name);
    }

    interface Presenter{

        void loadData();
    }
}
