package com.example.ine.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ine.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    String a="";
    String b="";

    Spinner SPdistrito, SPseccion;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
		
		SPdistrito = root.findViewById(R.id.AltaE12);
        SPseccion = root.findViewById(R.id.AltaE13);
		
		/**
         * Array
         */

        final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                getContext(), R.array.Distrito, android.R.layout.simple_spinner_item
        );
        SPdistrito.setAdapter(adapter1);

        /**
         * Eventos de spiners
         */
        SPdistrito.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String op = String.valueOf(SPdistrito.getSelectedItemId());
                int opcion = Integer.parseInt(op);

                if (opcion == 0) {

                } else if (opcion == 1) {
                    final ArrayAdapter<CharSequence> adapterseccion1 = ArrayAdapter.createFromResource(getContext(), R.array.Seccion1, android.R.layout.simple_spinner_item);
                    SPseccion.setAdapter(adapterseccion1);
                    a = adapter1.getItem(1).toString();
                    SPseccion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String op = String.valueOf(SPseccion.getSelectedItemId());
                            int opcion = Integer.parseInt(op);
                            System.out.println(op);
                            if (opcion == 0) {

                            } else if (opcion == 1) {
                                b = "";
                                b = adapterseccion1.getItem(1).toString();
                                Toast.makeText(getContext(), a + " " + b, Toast.LENGTH_SHORT).show();
                            } else if (opcion == 2) {
                                b = "";
                                b = adapterseccion1.getItem(2).toString();
                                Toast.makeText(getContext(), a + " " + b, Toast.LENGTH_SHORT).show();
                            } else if (opcion == 3) {
                                b = "";
                                b = adapterseccion1.getItem(3).toString();
                                Toast.makeText(getContext(), a + " " + b, Toast.LENGTH_SHORT).show();
                            } else if (opcion == 4) {
                                b = "";
                                b = adapterseccion1.getItem(4).toString();
                                Toast.makeText(getContext(), a + " " + b, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (opcion == 2) {
                    final ArrayAdapter<CharSequence> adapterseccion1 = ArrayAdapter.createFromResource(getContext(), R.array.Seccion2, android.R.layout.simple_spinner_item);
                    SPseccion.setAdapter(adapterseccion1);
                    a = adapter1.getItem(2).toString();
                    SPseccion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String op = String.valueOf(SPseccion.getSelectedItemId());
                            int opcion = Integer.parseInt(op);
                            System.out.println(op);
                            if (opcion == 0) {

                            } else if (opcion == 1) {
                                b = "";
                                b = adapterseccion1.getItem(1).toString();
                                Toast.makeText(getContext(), a + " " + b, Toast.LENGTH_SHORT).show();
                            } else if (opcion == 2) {
                                b = "";
                                b = adapterseccion1.getItem(2).toString();
                                Toast.makeText(getContext(), a + " " + b, Toast.LENGTH_SHORT).show();
                            } else if (opcion == 3) {
                                b = "";
                                b = adapterseccion1.getItem(3).toString();
                                Toast.makeText(getContext(), a + " " + b, Toast.LENGTH_SHORT).show();
                            } else if (opcion == 4) {
                                b = "";
                                b = adapterseccion1.getItem(4).toString();
                                Toast.makeText(getContext(), a + " " + b, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (opcion == 3) {
                    final ArrayAdapter<CharSequence> adapterseccion1 = ArrayAdapter.createFromResource(getContext(), R.array.Seccion3, android.R.layout.simple_spinner_item);
                    SPseccion.setAdapter(adapterseccion1);
                    a = adapter1.getItem(3).toString();
                    SPseccion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String op = String.valueOf(SPseccion.getSelectedItemId());
                            int opcion = Integer.parseInt(op);
                            System.out.println(op);
                            if (opcion == 0) {

                            } else if (opcion == 1) {
                                b = "";
                                b = adapterseccion1.getItem(1).toString();
                                Toast.makeText(getContext(), a + " " + b, Toast.LENGTH_SHORT).show();
                            } else if (opcion == 2) {
                                b = "";
                                b = adapterseccion1.getItem(2).toString();
                                Toast.makeText(getContext(), a + " " + b, Toast.LENGTH_SHORT).show();
                            } else if (opcion == 3) {
                                b = "";
                                b = adapterseccion1.getItem(3).toString();
                                Toast.makeText(getContext(), a + " " + b, Toast.LENGTH_SHORT).show();
                            } else if (opcion == 4) {
                                b = "";
                                b = adapterseccion1.getItem(4).toString();
                                Toast.makeText(getContext(), a + " " + b, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (opcion == 4) {
                    final ArrayAdapter<CharSequence> adapterseccion1 = ArrayAdapter.createFromResource(getContext(), R.array.Seccion4, android.R.layout.simple_spinner_item);
                    SPseccion.setAdapter(adapterseccion1);
                    a = adapter1.getItem(4).toString();
                    SPseccion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String op = String.valueOf(SPseccion.getSelectedItemId());
                            int opcion = Integer.parseInt(op);
                            System.out.println(op);
                            if (opcion == 0) {

                            } else if (opcion == 1) {
                                b = "";
                                b = adapterseccion1.getItem(1).toString();
                                Toast.makeText(getContext(), a + " " + b, Toast.LENGTH_SHORT).show();
                            } else if (opcion == 2) {
                                b = "";
                                b = adapterseccion1.getItem(2).toString();
                                Toast.makeText(getContext(), a + " " + b, Toast.LENGTH_SHORT).show();
                            } else if (opcion == 3) {
                                b = "";
                                b = adapterseccion1.getItem(3).toString();
                                Toast.makeText(getContext(), a + " " + b, Toast.LENGTH_SHORT).show();
                            } else if (opcion == 4) {
                                b = "";
                                b = adapterseccion1.getItem(4).toString();
                                Toast.makeText(getContext(), a + " " + b, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
		
        return root;
    }
}