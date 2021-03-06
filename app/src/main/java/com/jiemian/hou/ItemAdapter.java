package com.jiemian.hou;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> implements SpanVariableGridView.CalculateChildrenPosition {

	private final class ItemViewHolder {

		public TextView text_item;
		public ImageView iv_channel_image;

	}

	private Context mContext;
	private LayoutInflater mLayoutInflater = null;

	private View.OnClickListener onRemoveItemListener = new View.OnClickListener() {

		@Override
		public void onClick(View view) {

			Integer position = (Integer) view.getTag();
			removeItem(getItem(position));

		}
	};

	public void insertItem(Item item, int where) {

		if (where < 0 || where > (getCount() - 1)) {

			return;
		}

		insert(item, where);
	}

	public boolean removeItem(Item item) {

		remove(item);

		return true;
	}

	public ItemAdapter(Context context, List<Item> plugins) {

		super(context, R.layout.jm_tag_view, plugins);

		mContext = context;
		mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		final ItemViewHolder itemViewHolder;

		if (convertView == null) {
			convertView = mLayoutInflater.inflate(R.layout.jm_tag_view, parent, false);

//			itemViewHolder = new ItemViewHolder();
//			itemViewHolder.itemTitle = (TextView) convertView.findViewById(R.id.textViewTitle);
//			itemViewHolder.itemDescription = (TextView) convertView.findViewById(R.id.textViewDescription);
//			itemViewHolder.itemIcon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
//			convertView.setTag(itemViewHolder);

		} else {

			itemViewHolder = (ItemViewHolder) convertView.getTag();
		}

		final Item item = getItem(position);

//		SpanVariableGridView.LayoutParams lp = new LayoutParams(convertView.getLayoutParams());
//		lp.span = item.getSpans();
//		convertView.setLayoutParams(lp);
//
//		itemViewHolder.itemTitle.setText(item.getTitle());
//		itemViewHolder.itemDescription.setText(item.getDescription());
//		itemViewHolder.itemIcon.setImageResource(item.getIcon());

		return convertView;
	}

	@Override
	public void onCalculatePosition(View view, int position, int row, int column) {

	}
}
