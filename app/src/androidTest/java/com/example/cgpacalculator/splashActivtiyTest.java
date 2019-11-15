package com.example.cgpacalculator;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static org.junit.Assert.assertNotNull;

public class splashActivtiyTest {
    @Rule
    public ActivityTestRule<splashActivity> splashActivityTestRule=new ActivityTestRule<splashActivity>(splashActivity.class);
    private splashActivity splashActivity=null;

    @Before
    public void setUp() throws Exception {
        splashActivity=splashActivityTestRule.getActivity();

    }

    @Test
    public void testLaunch()
    {
        View view=splashActivity.findViewById(R.id.logo);
        assertNotNull(view);
    }



    @After
    public void tearDown() throws Exception {
        splashActivity=null;

    }
}
