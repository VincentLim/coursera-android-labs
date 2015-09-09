package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	// Use these as keys when you're saving state between reconfigurations
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

	//
	// Create variables named 	
	// mCreate, mRestart, mStart and mResume 	
	// to count calls to onCreate(), onRestart(), onStart() and
	// onResume(). These variables should not be defined as static.
	
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called.

	private int mCreate, mRestart, mStart, mResume;
	
	
	//  Create variables for each of the TextViews
	// named  mTvCreate, mTvRestart, mTvStart, mTvResume.
	// for displaying the current count of each counter variable
	private TextView mTvCreate, mTvRestart, mTvStart, mTvResume;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		//  Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);

		mTvCreate = (TextView) findViewById(R.id.create);
		mTvRestart = (TextView) findViewById(R.id.restart);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvResume = (TextView) findViewById(R.id.resume);
		
		
		
		
		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				//
				// This function closes Activity Two
				// Hint: use Context's finish() method
			ActivityTwo.this.finish();
				
			
			}
		});

		// Has previous state been saved?
		if (savedInstanceState != null) {

			//
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			mCreate = (Integer) savedInstanceState.get(CREATE_KEY);
			mRestart = (Integer) savedInstanceState.get(RESTART_KEY);
			mStart = (Integer) savedInstanceState.get(START_KEY);
			mResume = (Integer) savedInstanceState.get(RESUME_KEY);

			
			
			
			
		}

		// Emit LogCat message
		Log.i(TAG, "Entered the onCreate() method");

		//
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method

		mCreate++;
		displayCounts();
		
		
	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStart() method");

		mStart++;
		displayCounts();


		
		
	}

	@Override
	public void onResume() {
		super.onResume();

		// Emit LogCat message
		Log.i(TAG, "Entered the onResume() method");
		mResume++;
		displayCounts();


	
	}

	@Override
	public void onPause() {
		super.onPause();

		// Emit LogCat message
		Log.i(TAG, "Entered the onPause() method");
	}

	@Override
	public void onStop() {
		super.onStop();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStop() method");
	}

	@Override
	public void onRestart() {
		super.onRestart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onRestart() method");

		mRestart++;
		displayCounts();


	
	
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// Emit LogCat message
		Log.i(TAG, "Entered the onDestroy() method");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		savedInstanceState.putInt(CREATE_KEY, mCreate);
		savedInstanceState.putInt(RESTART_KEY, mRestart);
		savedInstanceState.putInt(START_KEY, mStart);
		savedInstanceState.putInt(RESUME_KEY, mResume);



		
		
		
		
	}

	// Updates the displayed counters
	// This method expects that the counters and TextView variables use the
	// names
	// specified above
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);

	
	}
}
