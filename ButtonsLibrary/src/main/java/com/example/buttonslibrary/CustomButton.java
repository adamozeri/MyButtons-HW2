package com.example.buttonslibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

public class CustomButton extends AppCompatButton {
    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomButton, 0, 0);

        boolean outline = a.getBoolean(R.styleable.CustomButton_outline, false);
        float rounded = a.getDimension(R.styleable.CustomButton_rounded, 0);
        boolean gradient = a.getBoolean(R.styleable.CustomButton_gradient, false);

        GradientDrawable defaultDrawable = new GradientDrawable();
        defaultDrawable.setCornerRadius(rounded);
        // Create and set the background
        if (outline && gradient) {
            int gradientStart = a.getColor(R.styleable.CustomButton_gradientStart, Color.TRANSPARENT);
            int gradientEnd = a.getColor(R.styleable.CustomButton_gradientEnd, Color.TRANSPARENT);
            GradientDrawable gradientDrawable = createGradientDrawable(gradientStart, gradientEnd, rounded);
            gradientDrawable.setStroke(2, Color.BLACK); // Set outline color and width
            gradientDrawable.setCornerRadius(rounded);
            setBackground(gradientDrawable);
        } else if (gradient) {
            int gradientStart = a.getColor(R.styleable.CustomButton_gradientStart, Color.TRANSPARENT);
            int gradientEnd = a.getColor(R.styleable.CustomButton_gradientEnd, Color.TRANSPARENT);
            GradientDrawable gradientDrawable = createGradientDrawable(gradientStart, gradientEnd, rounded);
            setBackground(gradientDrawable);
        } else if (outline) {
            setBackground(createOutlineDrawable(rounded));
        } else {
            defaultDrawable.setColor(Color.LTGRAY); // Default color
            setBackground(defaultDrawable);
        }

        a.recycle();
        setTypeface(null, Typeface.BOLD); // Set text to bold
        setPadding(16, 8, 16, 8); // Add padding if desired
    }

    private GradientDrawable createGradientDrawable(int startColor, int endColor, float cornerRadius) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{startColor, endColor});
        gradientDrawable.setCornerRadius(cornerRadius);
        return gradientDrawable;
    }

    private Drawable createOutlineDrawable(float cornerRadius) {
        GradientDrawable outlineDrawable = new GradientDrawable();
        outlineDrawable.setStroke(2, Color.BLACK); // Set outline color and width
        outlineDrawable.setCornerRadius(cornerRadius);
        return outlineDrawable;
    }
}


