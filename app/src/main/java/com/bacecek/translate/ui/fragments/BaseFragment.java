package com.bacecek.translate.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.arellomobile.mvp.MvpFragment;
import com.bacecek.translate.R;
import com.bacecek.translate.ui.events.ClickMenuEvent;
import org.greenrobot.eventbus.EventBus;

/**
 * Created by Denis Buzmakov on 03/04/2017.
 * <buzmakov.da@gmail.com>
 */

public class BaseFragment extends MvpFragment {

	public void setTitle(View parent, String text) {
		TextView txtToolbarTitle = (TextView)parent.findViewById(R.id.txt_toolbar_title);
		if(txtToolbarTitle != null) {
			txtToolbarTitle.setText(text);
		}
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ImageButton btnMenu = (ImageButton) view.findViewById(R.id.btn_menu);
		if(btnMenu != null) {
			btnMenu.setOnClickListener(v -> EventBus.getDefault().post(new ClickMenuEvent()));
		}
	}
}
