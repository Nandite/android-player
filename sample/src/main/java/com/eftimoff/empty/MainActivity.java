package com.eftimoff.empty;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.eftimoff.androidplayer.Player;
import com.eftimoff.androidplayer.actions.arc.CurveAction;
import com.eftimoff.androidplayer.actions.property.PropertyAction;
import com.eftimoff.androidplayer.listeners.PlayerEndListener;
import com.eftimoff.androidplayer.listeners.PlayerStartListener;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View toolbar = findViewById(R.id.toolbar);
        final View activityMainMessageIcon = findViewById(R.id.activityMainMessageIcon);
        final View activityMainMobile = findViewById(R.id.activityMainMobile);
        final View activityMainMobileNumber = findViewById(R.id.activityMainMobileNumber);
        final View activityMainCallIcon = findViewById(R.id.activityMainCallIcon);
        final View activityMainMobileNumberLayout = findViewById(R.id.activityMainMobileNumberLayout);
        final View activityMainPinkFab = findViewById(R.id.activityMainPinkFab);
        final View activityMainProfileName = findViewById(R.id.activityMainProfileName);
        final View activityMainDrawerLayout = findViewById(R.id.activityMainDrawerLayout);
        final View activityMainheaderLayout = findViewById(R.id.activityMainheaderLayout);

        initDrawerLayout();

        animateSampleOne(toolbar, activityMainMobileNumberLayout, activityMainPinkFab, activityMainheaderLayout);
//        animateSampleTwo(toolbar, activityMainMobileNumberLayout, activityMainPinkFab, activityMainheaderLayout);
//        animateSampleThree(toolbar, activityMainMobileNumberLayout, activityMainPinkFab, activityMainheaderLayout, activityMainMessageIcon);
//        animateSampleFour(toolbar, activityMainMessageIcon, activityMainMobile, activityMainMobileNumber, activityMainCallIcon, activityMainPinkFab, activityMainheaderLayout);
        //animateSampleFive(activityMainProfileName);
    }


    private void animateSampleOne(View toolbar, View activityMainMobileNumberLayout, View activityMainPinkFab, View activityMainheaderLayout) {
        final PropertyAction fabAction = PropertyAction.newPropertyAction(activityMainPinkFab).scaleX(0).scaleY(0).duration(750).interpolator(new AccelerateDecelerateInterpolator()).build();
        final PropertyAction headerAction = PropertyAction.newPropertyAction(activityMainheaderLayout).interpolator(new DecelerateInterpolator()).translationY(-200).duration(550).alpha(0.4f).build();
        final PropertyAction bottomAction = PropertyAction.newPropertyAction(activityMainMobileNumberLayout).translationY(500).duration(750).alpha(0f).build();
        Player.init().
                animate(headerAction).
                then().
                animate(fabAction).
                then().
                animate(bottomAction).
                play();
    }

    private void animateSampleTwo(View toolbar, View activityMainMobileNumberLayout, View activityMainPinkFab, View activityMainheaderLayout) {
        final PropertyAction fabAction = PropertyAction.newPropertyAction(activityMainPinkFab).translationX(200).duration(750).interpolator(new AccelerateDecelerateInterpolator()).build();
        final PropertyAction headerAction = PropertyAction.newPropertyAction(activityMainheaderLayout).interpolator(new DecelerateInterpolator()).duration(550).alpha(0.0f).build();
        final PropertyAction bottomAction = PropertyAction.newPropertyAction(activityMainMobileNumberLayout).duration(2500).alpha(0f).build();
        final CurveAction curveAction = CurveAction.newControlPointsCurveAction(activityMainMobileNumberLayout).translationX(-500).translationY(100).controlPoint1X(-500).controlPoint1Y(255.5f).controlPoint2X(0).controlPoint2Y(255.5f).duration(2500).build();
        Player.init().
                animate(headerAction).
                then().
                animate(fabAction).
                then().
                animate(bottomAction).
                animate(curveAction).
                play();
    }

    private void animateSampleThree(View activityMainProfileName, View activityMainMobileNumberLayout, View activityMainPinkFab, View activityMainheaderLayout, View activityMainMessageIcon) {
        final PropertyAction propertyAction = PropertyAction.newPropertyAction(activityMainheaderLayout).translationX(-200).duration(1500).interpolator(new AccelerateDecelerateInterpolator()).alpha(0.4f).build();
        final PropertyAction headerPropertyAction = PropertyAction.newPropertyAction(activityMainProfileName).interpolator(new DecelerateInterpolator()).translationY(-200).duration(3750).delay(1233).alpha(0.4f).build();
        final PropertyAction viewSecondAction = PropertyAction.newPropertyAction(activityMainPinkFab).translationY(200).duration(750).alpha(0f).build();
        final PropertyAction bottomPropertyAction = PropertyAction.newPropertyAction(activityMainMobileNumberLayout).rotation(-180).scaleX(0.1f).scaleY(0.1f).translationX(-200).duration(750).build();
        Player.init().
                setPlayerStartListener(playerStartListener).
                setPlayerEndListener(playerEndListener).
                animate(propertyAction).
                animate(headerPropertyAction).
                then().
                animate(viewSecondAction).
                then().
                animate(bottomPropertyAction).
                play();
    }

    private void animateSampleFour(View toolbar, View activityMainMessageIcon, View activityMainMobile, View activityMainMobileNumber, View activityMainCallIcon, View activityMainPinkFab, View activityMainheaderLayout) {
        final PropertyAction fabAction = PropertyAction.newPropertyAction(activityMainPinkFab).scaleX(0).scaleY(0).duration(750).interpolator(new AccelerateDecelerateInterpolator()).build();
        final PropertyAction headerAction = PropertyAction.newPropertyAction(activityMainheaderLayout).interpolator(new DecelerateInterpolator()).translationY(-200).duration(750).alpha(0.4f).build();
        final PropertyAction bottomAction = PropertyAction.newPropertyAction(activityMainCallIcon).scaleX(0).scaleY(0).duration(750).alpha(0f).build();
        final PropertyAction activityMainMobileNumberAction = PropertyAction.newPropertyAction(activityMainMobileNumber).scaleX(0).scaleY(0).duration(550).alpha(0f).build();
        final PropertyAction activityMainMobileAction = PropertyAction.newPropertyAction(activityMainMobile).translationY(300).duration(750).alpha(0f).build();
        final PropertyAction activityMainMessageIconAction = PropertyAction.newPropertyAction(activityMainMessageIcon).scaleX(0).scaleY(0).duration(350).alpha(0f).build();
        Player.init().
                animate(headerAction).
                then().
                animate(fabAction).
                then().
                animate(bottomAction).
                then().
                animate(activityMainMobileNumberAction).
                animate(activityMainMobileAction).
                then().
                animate(activityMainMessageIconAction).
                play();
    }

    private void animateSampleFive(View activityMainMessageIcon) {
        final PropertyAction headerAction1 = PropertyAction.newPropertyAction(activityMainMessageIcon).scaleX(0.5f).scaleY(0.5f).duration(500).build();
        final PropertyAction headerAction2 = PropertyAction.newPropertyAction(activityMainMessageIcon).scaleX(2).scaleY(2).duration(500).build();

        Player.init().
                animate(headerAction1).
                then().
                animate(headerAction2).
                loop(5).
                play();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.player_menu, menu);
        return true;
    }

    private PlayerStartListener playerStartListener = new PlayerStartListener() {
        @Override
        public void onStart() {
//            Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_SHORT).show();
        }
    };
    private PlayerEndListener playerEndListener = new PlayerEndListener() {
        @Override
        public void onEnd() {
//            Toast.makeText(getApplicationContext(), "End", Toast.LENGTH_SHORT).show();
        }
    };

    private void initDrawerLayout() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar supportActionBar = getSupportActionBar();
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.activityMainDrawerLayout);
        final ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.abc_toolbar_collapse_description,
                R.string.abc_toolbar_collapse_description);
        drawerToggle.setDrawerIndicatorEnabled(true);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setHomeButtonEnabled(true);
        supportActionBar.setDisplayShowTitleEnabled(false);
        drawerToggle.syncState();
        drawerLayout.setDrawerListener(drawerToggle);
    }
}
