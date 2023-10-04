package com.ndroid.filelinker20.widget;

import com.ndroid.filelinker20.exception.NotReadyException;
import com.ndroid.filelinker20.object.Editable;
import com.genonbeta.android.framework.widget.ListAdapterImpl;

import java.util.List;

/**
 * created by: veli
 * date: 14/04/18 00:51
 */
public interface EditableListAdapterImpl<T extends Editable> extends ListAdapterImpl<T>
{
    boolean filterItem(T item);

    T getItem(int position) throws NotReadyException;

    void notifyAllSelectionChanges();

    void notifyItemChanged(int position);

    void notifyItemRangeChanged(int positionStart, int itemCount);

    void syncSelectionList();

    void syncSelectionList(List<T> itemList);
}
