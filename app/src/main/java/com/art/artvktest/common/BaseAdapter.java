package com.art.artvktest.common;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.support.v4.util.ArrayMap;

import com.art.artvktest.model.view.BaseViewModel;
import com.art.artvktest.ui.holder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;
/** Адаптер работает следующим образом.
 * Добавляем элементы в адаптер методом addItems(). Этот метод добавляет элементы в список моделей list
 * и в список типов mTypeInstance, если там уже нет такого типа. После того, как в методе addItems()
 * вызываем notifyDataSetChanged() адаптер проверяет количество элементов и, если оно больше нуля,
 * он начинает создавать столько ViewHolder, сколько поместится на экране.
 * Вызывается метод onCreateViewHolder() с параметром viewType, взятым из метода getItemViewType().
 * Переопределяем метод getItemViewType(), возвращая тип модели.
 * Далее в методе onCreateViewHolder() получаем необходимый тип модели и вызываем у нее метод
 * createViewHolder(). После этого вызывается метод onBindViewHolder(), где заполняется макет. При
 * прокрутке адаптер освобождает не нужные ViewHolder и вызывается метод onViewRecycled(), где мы
 * очищаем ViewHolder. Новый ViewHolder создается, если нет свободных такого же типа*/
public class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder<BaseViewModel>> {

    //переменная содержит все добавленные в адаптер єлементы
    //отсюда берутся данные для заполнения в методе onBindViewHolder
    private List<BaseViewModel> list = new ArrayList<>();

    //список из элементов ключ-значение, где ключ - тип модели и макета, а значение - сама модель
    //нужен для того, чтобы создавать ViewHolder конкретного типа в методе onCreateViewHolder
    private ArrayMap<Integer, BaseViewModel> mTypeInstance = new ArrayMap<>();

    @Override
    public BaseViewHolder<BaseViewModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        return mTypeInstance.get(viewType).createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<BaseViewModel> holder, int position) {
        holder.bindViewHolder(getItem(position));
    }

    //возвращает тип ViewItem
    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType().getValue();
    }

    @Override
    public void onViewRecycled(BaseViewHolder<BaseViewModel> holder) {
        super.onViewRecycled(holder);
        holder.unbindViewHolder();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //возвращает item по позиции
    public BaseViewModel getItem(int position) {
        return list.get(position);
    }

    //при каждом добавлении необходимо регистрировать тип Layout
    public void registerTypeInstance(BaseViewModel item) {
        if (!mTypeInstance.containsKey(item.getType().getValue())) {
            mTypeInstance.put(item.getType().getValue(), item);
        }
    }

    //метод добавления элементов в список
    public void addItems(List<? extends BaseViewModel> newItems) {
        for (BaseViewModel newItem : newItems)
            registerTypeInstance(newItem);

        list.addAll(newItems);
        notifyDataSetChanged();
    }

    //чистим список и добавляем новый элемент
    public void setItems(List<BaseViewModel> items) {
        clearList();
        addItems(items);
    }

    public void clearList() {
        list.clear();
    }
}
