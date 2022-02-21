package kg.geektech.filmapp.ui.films;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.geektech.filmapp.common.OnItemClick;
import kg.geektech.filmapp.data.models.Film;
import kg.geektech.filmapp.databinding.ItemFilmBinding;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {
    private List<Film> film= new ArrayList<>();
    private OnItemClick listener;

    public void setListener(OnItemClick listener) {
        this.listener = listener;
    }

    public void setFilm(List<Film> film) {
        this.film = film;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmBinding binding=ItemFilmBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false);
        return new FilmsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {
        holder.onBind(film.get(position));






    }

    @Override
    public int getItemCount() {
        return film.size();
    }

    protected class FilmsViewHolder extends RecyclerView.ViewHolder{

private ItemFilmBinding binding;
        public FilmsViewHolder(@NonNull ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }

        public void onBind(Film film) {
            binding.tvTitle.setText(film.getTitle());
            binding.tvDescription.setText(film.getDescription());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(film, film.getId());

                }
            }) ;
        }
    }
}
