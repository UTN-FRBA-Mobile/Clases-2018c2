package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

public interface MainContract {
    interface View{
        void showGreeting(String name);

        void showVideo(String name, String description, String preview);

        void showError(String message);

        void progress(boolean isShow);
    }

    interface Presenter{

        void sayHi(String name);

        void loadVideo();
    }
}
