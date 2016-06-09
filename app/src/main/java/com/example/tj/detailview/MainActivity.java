package com.example.tj.detailview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";

    private final static int KIND_OF_TASTE = 4;
    private final static int[][] CLOUD_MESSAGE_MARGIN =
            {
                    {50, 5, 0, 0},     // 첫번째 클라우드 메시지
                    {270, 5, 0, 0},
                    {490, 5, 0, 0},
                    {170, 120, 0, 0},
                    {380, 120, 0, 0}
            };

    double[] tasteStep = {6.4, 2.1, 9.7, 3.3};

    RelativeLayout tasteLayout;
    RelativeLayout footerLayout;
    ImageView foodView;
    TextView foodName;
    TextView foodComent;
    Resources res;

    TextView[] taste_View;
    Animation[] animation;
    Animation cloudeAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cloudeAnimation = AnimationUtils.loadAnimation(this,R.anim.cloud_animation);
        taste_View = new TextView[KIND_OF_TASTE];

        footerLayout = (RelativeLayout)findViewById(R.id.footerLayout);
        tasteLayout = (RelativeLayout)findViewById(R.id.tasteLayout);
        res = getResources();

        foodView = (ImageView)findViewById(R.id.foodView);
        foodName = (TextView)findViewById(R.id.foodName);
        foodComent = (TextView)findViewById(R.id.foodComent);

        foodView.setImageDrawable(res.getDrawable(R.drawable.chicken));
        foodName.setText("치킨");
        foodComent.setText("지방질이 적고 소화흡수가 좋은 단백질이 많으며, 근육 속에 지방이 섞여 있지 않아 맛이 담백하고 소화흡수가 잘 되는 것이 특징");

        String[] tasteKind = new String[]{"매콤","달콤","새콤","느끼한 맛"};

        tasteViewDraw(tasteKind, KIND_OF_TASTE);  // 맛 별로 원 그리기

        // 맛의 농도를 배열로 넘겨주기
        TasteAnimation tasteAnimation = new TasteAnimation(this, tasteStep);
        animation = tasteAnimation.scaleAnimation();
        setFillAftre(animation);

        startAnimationSetting(taste_View,animation,4);

        String[] menuTag = new String[]{"진리의 치맥","야식","두마리 치킨","순살","칼로리 1500"};
        menuTagDraw(menuTag);   // 클라우드 메시지 띄우기

        /*   페인트로 이미지 그리기
        int []rgb = {100,100,100};
        PaintView paintView = new PaintView(this,rgb,250,250,40,"느끼한");
        PaintView paintView1 = new PaintView(this, Color.RED,460,120,50,"매콤");
        PaintView paintView2 = new PaintView(this, Color.YELLOW,300,200,70,"새콤");
        PaintView paintView3 = new PaintView(this, Color.BLUE,440,300,50,"달콤");
        paintView.startAnimation(animation[0]);
        paintView1.startAnimation(animation[1]);
        paintView2.startAnimation(animation[2]);
        paintView3.startAnimation(animation[3]);
        tasteLayout.addView(paintView);
        tasteLayout.addView(paintView1);
        tasteLayout.addView(paintView2);
        tasteLayout.addView(paintView3);
        */
    }

    // 애니메이션 종료 후에도 크기 유지
    public void setFillAftre(Animation[] ani){
        int size = ani.length;

        for(int i=0;i<size;i++){
            ani[i].setFillAfter(true);
        }
    }

    // 애니메이션 시작
    public void startAnimationSetting(TextView[] textView, Animation[] animation, int size){
        for(int i = 0;i<size;i++){
            textView[i].startAnimation(animation[i]);
        }
    }

    public void tasteViewDraw(String[] text ,int size){

        for(int i=0; i<size;i++){
            if(i==0) {
                taste_View[0] = (TextView) findViewById(R.id.spicy);
                taste_View[0].setBackground(res.getDrawable(R.drawable.red_circle));
            }
            else if(i==1) {
                taste_View[1] = (TextView) findViewById(R.id.dalkomm);
                taste_View[1].setBackground(res.getDrawable(R.drawable.yellow_circle));
            }
            else if(i==2) {
                taste_View[2] = (TextView) findViewById(R.id.saekomm);
                taste_View[2].setBackground(res.getDrawable(R.drawable.orrange_circle));
            }
            else if(i==3) {
                taste_View[3] = (TextView) findViewById(R.id.nkki);
                taste_View[3].setBackground(res.getDrawable(R.drawable.ltgreen_circle));
            }
        }

        for(int i=0; i<size;i++){
            taste_View[i].setText(text[i]+(int)tasteStep[i]);
            taste_View[i].setGravity(Gravity.CENTER);
        }
    }

    // 클라우드 메시지 생성
    public void menuTagDraw(String[] cloudMessage){

        int maxSize = 5;
        RelativeLayout.LayoutParams[] params = new RelativeLayout.LayoutParams[maxSize];
        TextView[] cloudView = new TextView[maxSize];

        for(int i = 0; i< maxSize; i++){

            params[i] = new  RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            cloudView[i] = new TextView(this);
            cloudView[i].setBackground(res.getDrawable(R.drawable.cloud_size));
            cloudView[i].setText(cloudMessage[i]);
            cloudView[i].setTextColor(Color.WHITE);
            cloudView[i].setGravity(Gravity.CENTER);
            params[i].setMargins(CLOUD_MESSAGE_MARGIN[i][0], CLOUD_MESSAGE_MARGIN[i][1], CLOUD_MESSAGE_MARGIN[i][2], CLOUD_MESSAGE_MARGIN[i][3]);
            footerLayout.addView(cloudView[i], params[i]);
            cloudView[i].startAnimation(cloudeAnimation);

        }

    }
}
