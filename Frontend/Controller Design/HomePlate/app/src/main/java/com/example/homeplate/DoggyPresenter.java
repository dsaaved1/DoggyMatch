package com.example.homeplate;

public class DoggyPresenter implements DoggyInterface.DoggyPresenter, DoggyInterface.DoggyModel.OnFinishedListener{

    private DoggyInterface.DoggyView mainView;

    // creating object of Model Interface
    private DoggyInterface.DoggyModel model;

    // instantiating the objects of View and Model Interface
    public DoggyPresenter(DoggyInterface.DoggyView mainView, DoggyInterface.DoggyModel model) {
        this.mainView = mainView;
        this.model = model;
    }

    @Override
    // operations to be performed
    // on button click
    public void onButtonClick() {
        if (mainView != null) {
            mainView.showProgress();
        }
        model.getNextCourse(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    // method to return the string
    // which will be displayed in the
    // Course Detail TextView
    public void onFinished(String string) {
        if (mainView != null) {
            mainView.setString(string);
            mainView.hideProgress();
        }
    }

}
