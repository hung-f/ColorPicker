package android.kermell.com.demo;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

import com.hungdha.colorpicker.ColorPicker;
import com.hungdha.colorpicker.OnColorSelectedListener;
import com.hungdha.holocolorpicker.HoloColorPicker;



public class MainActivity extends Activity {

	private Button colorPickerBtn;
	private Button holoColorPickerBtn;
	private com.hungdha.colorpicker.ColorPicker colorPicker;
	private com.hungdha.holocolorpicker.HoloColorPicker holoColorPicker;
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


		colorPickerBtn = (Button) findViewById(R.id.colorPicker);
		colorPickerBtn.setBackgroundColor(color_1);
		OnColorSelectedListener button1ColorSelectedListener = new OnColorSelectedListener() {
			@Override
			public void onSelected(int selectedColor) {
				colorPickerBtn.setBackgroundColor(selectedColor);
			}
		};
		colorPicker = new ColorPicker(this, color_1, button1ColorSelectedListener, presetColors);
		colorPickerBtn.setOnClickListener(new OnStartButton(colorPicker
				.getDialog()));

		/*
		holoColorPickerBtn = (Button) findViewById(R.id.holoPicker);
		holoColorPickerBtn.setBackgroundColor(color_2);
		HoloColorPicker.OnColorSelectedListener button2ColorSelectedListener = new HoloColorPicker.OnColorSelectedListener() {
			@Override
			public void onColorSelected(int color) {
				colorPickerBtn.setBackgroundColor(color);
			}
		};
		holoColorPicker = new HoloColorPicker(this, color_2, button2ColorSelectedListener, presetColors);
		holoColorPickerBtn.setOnClickListener(new OnStartButton(holoColorPicker.getDialog()));*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
