package com.ndroid.filelinker20.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.ndroid.filelinker20.R;
import com.ndroid.filelinker20.graphics.drawable.TextDrawable;
import com.ndroid.filelinker20.object.ShowingAssignee;
import com.ndroid.filelinker20.object.TransferGroup;
import com.ndroid.filelinker20.util.AppUtils;
import com.ndroid.filelinker20.util.NetworkDeviceLoader;
import com.ndroid.filelinker20.util.TextUtils;
import com.ndroid.filelinker20.util.TransferUtils;
import com.ndroid.filelinker20.widget.EditableListAdapter;

import java.util.List;

/**
 * created by: veli
 * date: 06.04.2018 12:46
 */
public class TransferAssigneeListAdapter extends EditableListAdapter<ShowingAssignee, EditableListAdapter.EditableViewHolder>
{
    private TransferGroup mGroup;
    private TextDrawable.IShapeBuilder mIconBuilder;

    public TransferAssigneeListAdapter(Context context)
    {
        super(context);
        mIconBuilder = AppUtils.getDefaultIconBuilder(context);
    }

    @NonNull
    @Override
    public EditableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new EditableViewHolder(getInflater().inflate(
                isHorizontalOrientation() || isGridLayoutRequested()
                        ? R.layout.list_assignee_grid
                        : R.layout.list_assignee, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EditableViewHolder holder, int position)
    {
        ShowingAssignee assignee = getList().get(position);

        ImageView image = holder.getView().findViewById(R.id.image);
        TextView text1 = holder.getView().findViewById(R.id.text1);
        TextView text2 = holder.getView().findViewById(R.id.text2);

        text1.setText(assignee.device.nickname);
        text2.setText(TextUtils.getAdapterName(getContext(), assignee.connection));
        NetworkDeviceLoader.showPictureIntoView(assignee.device, image, mIconBuilder);
    }

    @Override
    public List<ShowingAssignee> onLoad()
    {
        return TransferUtils.loadAssigneeList(AppUtils.getDatabase(getContext()), mGroup.groupId);
    }

    public TransferAssigneeListAdapter setGroup(TransferGroup group)
    {
        mGroup = group;
        return this;
    }
}
