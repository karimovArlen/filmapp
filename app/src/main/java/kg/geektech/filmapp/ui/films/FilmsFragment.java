package kg.geektech.filmapp.ui.films;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kg.geektech.filmapp.App;
import kg.geektech.filmapp.R;
import kg.geektech.filmapp.common.OnItemClick;
import kg.geektech.filmapp.data.models.Film;
import kg.geektech.filmapp.databinding.FragmentFilmsBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FilmsFragment extends Fragment implements OnItemClick  {

    private FragmentFilmsBinding binding;
    private  FilmsAdapter adapter;

    public FilmsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter= new FilmsAdapter();
        adapter.setListener(this);

        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    binding=FragmentFilmsBinding.inflate(
            inflater,
            container,
             false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recycler.setAdapter(adapter);
        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setFilm(response.body());
                    Log.e("TAG", "onResponse:");
                } else {
                    Log.e("TAG", "onResponse:"+response.errorBody().toString());
                }

            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                Log.e("TAG", "onFailure:"+t.getLocalizedMessage());

            }
        });
    }





    @Override
    public void onItemClick(Film film, String id) {
        App.api.getFilmByID(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null){
                    NavController navController= Navigation.findNavController(requireActivity(),
                            R.id.nav_host_fragment);
                    Bundle bundle= new Bundle();
                    bundle.putString("movieBanner", film.getMovieBanner());
                    bundle.putString("title", film.getTitle());
                    bundle.putString("oTitle", film.getOriginalTitle());
                    bundle.putString("director", film.getDirector());
                    bundle.putString("Producer", film.getProducer());
                    navController.navigate(R.id.detailFragment, bundle);


                }

            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });

    }
}

