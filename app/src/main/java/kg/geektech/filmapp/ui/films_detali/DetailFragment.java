package kg.geektech.filmapp.ui.films_detali;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import kg.geektech.filmapp.R;
import kg.geektech.filmapp.databinding.FragmentDetaliBinding;


public class DetailFragment extends Fragment {
    FragmentDetaliBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding=FragmentDetaliBinding.inflate(inflater, container, false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    String photo= requireArguments().getString("movieBanner");
        Glide.with(binding.movieBanner).load(photo).circleCrop().into(binding.movieBanner);
        String title= requireArguments().getString("title");
        binding.title.setText(title);
        String oTitle= requireArguments().getString("oTitle");
        binding.originalTitle.setText(oTitle);
        String director= requireArguments().getString("director");
        binding.director.setText(director);
        String Producer= requireArguments().getString("Producer");
        binding.producer.setText(Producer);

    }

}