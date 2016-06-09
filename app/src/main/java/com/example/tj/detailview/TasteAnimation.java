package com.example.tj.detailview;

import android.content.Context;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by TJ on 2016-06-07.
 */
public class TasteAnimation {
    private final static String TAG = "TasteAnimation";

    private final static double FIRST_STEP_SIZE = 0.0;
    private final static double SECOND_STEP_SIZE = 2.5;
    private final static double THIRD_STEP_SIZE = 5.0;
    private final static double FOURTH_STEP_SIZE = 7.5;
    private final static double FIFTH_STEP_SIZE = 10.0;

    Animation[] taste_Animation;

    Context context;
    double tasteScale[];

    public TasteAnimation(Context context) {
        this.context = context;
    }

    public TasteAnimation(Context context, double[] tasteScale) {
        this.context = context;
        this.tasteScale = tasteScale;
    }

    public Animation[] scaleAnimation(){

        int size = tasteScale.length;

        taste_Animation = new Animation[size];

        for(int i =0; i<size;i++){

            if(tasteScale[i] >= FIRST_STEP_SIZE && tasteScale[i] <= SECOND_STEP_SIZE) {
                if(i==0){
                    taste_Animation[0] = AnimationUtils.loadAnimation(context,R.anim.scale);
                }
                else if(i==1){
                    taste_Animation[1] = AnimationUtils.loadAnimation(context,R.anim.scale);
                }
                else if(i==2){
                    taste_Animation[2] = AnimationUtils.loadAnimation(context,R.anim.scale);
                }
                else if(i==3){
                    taste_Animation[3] = AnimationUtils.loadAnimation(context,R.anim.scale);
                }
                else {
                    Log.d(TAG,"범위 초과");
                }
            } else if(tasteScale[i] >= SECOND_STEP_SIZE && tasteScale[i] <= THIRD_STEP_SIZE) {
                if(i==0){
                    taste_Animation[0] = AnimationUtils.loadAnimation(context,R.anim.scale2);
                }
                else if(i==1){
                    taste_Animation[1] = AnimationUtils.loadAnimation(context,R.anim.scale2);
                }
                else if(i==2){
                    taste_Animation[2] = AnimationUtils.loadAnimation(context,R.anim.scale2);
                }
                else if(i==3){
                    taste_Animation[3] = AnimationUtils.loadAnimation(context,R.anim.scale2);
                }
                else {
                    Log.d(TAG,"범위 초과");
                }
            } else if(tasteScale[i] >= THIRD_STEP_SIZE && tasteScale[i] <= FOURTH_STEP_SIZE) {
                if(i==0){
                    taste_Animation[0] = AnimationUtils.loadAnimation(context,R.anim.scale3);
                }
                else if(i==1){
                    taste_Animation[1] = AnimationUtils.loadAnimation(context,R.anim.scale3);
                }
                else if(i==2){
                    taste_Animation[2] = AnimationUtils.loadAnimation(context,R.anim.scale3);
                }
                else if(i==3){
                    taste_Animation[3] = AnimationUtils.loadAnimation(context,R.anim.scale3);
                }
                else {
                    Log.d(TAG,"범위 초과");
                }
            }else if(tasteScale[i] >= FOURTH_STEP_SIZE && tasteScale[i] <= FIFTH_STEP_SIZE){
                if(i==0){
                    taste_Animation[0] = AnimationUtils.loadAnimation(context,R.anim.scale4);
                }
                else if(i==1){
                    taste_Animation[1] = AnimationUtils.loadAnimation(context,R.anim.scale4);
                }
                else if(i==2){
                    taste_Animation[2] = AnimationUtils.loadAnimation(context,R.anim.scale4);
                }
                else if(i==3){
                    taste_Animation[3] = AnimationUtils.loadAnimation(context,R.anim.scale4);
                }
                else {
                    Log.d(TAG,"범위 초과");
                }
            }
        }

        return taste_Animation;
    }

}
