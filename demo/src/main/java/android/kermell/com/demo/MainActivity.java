package android.kermell.com.demo;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

import com.hungdha.colorpicker.ColorPicker;
import com.hungdha.colorpicker.OnColorSelectedListener;

public class MainActivity extends Activity {

	private Button startButton_1;
	private Button startButton_2;
	private Button startButton_3;
	private ColorPicker colorPicker_1;
	private ColorPicker colorPicker_2;
	private int color_1 = Color.rgb(55, 128, 128);
	private int color_2 = Color.argb(128, 128, 128, 255);
	private ArrayList<Integer> presetColors = new ArrayList<Integer>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		presetColors.add(Color.BLUE);
		presetColors.add(Color.CYAN);
		presetColors.add(Color.argb(255, 222, 100, 18));
		presetColors.add(Color.argb(128, 222, 100, 18));
		presetColors.add(Color.argb(10, 128, 128, 128));

		
		startButton_1 = (Button) findViewById(R.id.startColorPicker_1);
		startButton_1.setBackgroundColor(color_1);
		OnColorSelectedListener button1ColorSelectedListener = new OnColorSelectedListener() {
			@Override
			public void onSelected(int selectedColor) {
				startButton_1.setBackgroundColor(selectedColor);
			}
		};
		colorPicker_1 = new ColorPicker(this, color_1, button1ColorSelectedListener, presetColors);
		startButton_1.setOnClickListener(new OnStartButton(colorPicker_1
				.getDialog()));
		
		startButton_2 = (Button) findViewById(R.id.startColorPicker_2);
		startButton_2.setBackgroundColor(color_2);
		OnColorSelectedListener button2ColorSelectedListener = new OnColorSelectedListener() {
			
			@Override
			public void onSelected(int selectedColor) {
				startButton_2.setBackgroundColor(selectedColor);
			}
		};
		colorPicker_2 = new ColorPicker(this, color_2, button2ColorSelectedListener, presetColors);
		startButton_2.setOnClickListener(new OnStartButton(colorPicker_2
				.getDialog()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
