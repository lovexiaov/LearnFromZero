package com.lovexiaov.learnfromzero;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.ListView;
import android.widget.Toast;

import com.lovexiaov.learnfromzero.entity.Func;
import com.lovexiaov.learnfromzero.receiver.RecvLocal;
import com.lovexiaov.learnfromzero.receiver.RecvNetChange;
import com.lovexiaov.learnfromzero.tools.Closer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AtyMain extends AtyBase {

    private ListView list_func;
    private AdapterFuncList funcAdapter;
    private List<Func> funcs;

    private IntentFilter filter;
    private RecvNetChange recvNetChange;


    private LocalBroadcastManager localManager;
    private RecvLocal recvLocal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // hide title bar
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.aty_main);

        initData();

        list_func = (ListView) super.findViewById(R.id.list_func);
        funcAdapter = new AdapterFuncList(this, R.layout.list_func, funcs);
        list_func.setAdapter(funcAdapter);

        localManager = LocalBroadcastManager.getInstance(this);
        recvLocal = new RecvLocal();
        IntentFilter filter = new IntentFilter("com.lovexiaov.learnfromzero.ACTION_LOCAL_CUSTOM");
        localManager.registerReceiver(recvLocal, filter);
    }

    private void initData() {
        funcs = new ArrayList<>();
        Func easyStart = new Func(getString(R.string.start_aty_easy_start), new Func.OnClickListener() {
            @Override
            public void action() {
                AtyEasyStart.actionStart(AtyMain.this, "lovexiaov", "ITer");

            }
        });
        Func showAlert = new Func(getString(R.string.show_alert_dialog), new Func.OnClickListener() {
            @Override
            public void action() {
                showAlert();
            }
        });

        Func showPBDialog = new Func(getString(R.string.show_progress_dialog), new Func.OnClickListener() {
            @Override
            public void action() {
                showProgressDialog();
            }
        });

        Func showTableLayout = new Func(getString(R.string.show_table_layout), new Func.OnClickListener() {
            @Override
            public void action() {
                showTableLayoutAty();
            }
        });

        Func showCustomView = new Func(getString(R.string.show_custom_view), new Func.OnClickListener() {
            @Override
            public void action() {
                showCustomViewAty();
            }
        });

        Func showListView = new Func(getString(R.string.show_list_view), new Func.OnClickListener() {
            @Override
            public void action() {
                showListViewAty();
            }
        });

        Func showFragment = new Func(getString(R.string.show_fragment), new Func.OnClickListener() {
            @Override
            public void action() {
                showFragmentAty();
            }
        });

        Func startReceiver = new Func(getString(R.string.start_receiver), new Func.OnClickListener() {
            @Override
            public void action() {
                registerNetChangeReceiver();
            }
        });

        Func sendCustomBroadcast = new Func(getString(R.string.send_custom_broadcast), new Func.OnClickListener() {
            @Override
            public void action() {
//                sendBroadcast(new Intent("com.lovexiaov.learnfromzero.ACTION_CUSTOM"));
                sendOrderedBroadcast(new Intent("com.lovexiaov.learnfromzero.ACTION_CUSTOM"), null);
            }
        });

        Func sendLocalBroadcast = new Func(getString(R.string.use_local_broadcast), new Func.OnClickListener() {
            @Override
            public void action() {
                sendLocalBroadcast();
            }
        });

        Func add_new_item = new Func(getString(R.string.add_new_item), new Func.OnClickListener() {
            @Override
            public void action() {
                Func test = new Func(getString(R.string.test_item), new Func.OnClickListener() {
                    @Override
                    public void action() {
                        Toast.makeText(AtyMain.this, "I was added dynamic ~~", Toast.LENGTH_SHORT).show();
                    }
                });
                funcs.add(test);
                funcAdapter.refresh(funcs);
            }
        });

        Func force_offline = new Func(getString(R.string.force_offline), new Func.OnClickListener() {
            @Override
            public void action() {
                sendBroadcast(new Intent("com.lovexiaov.learnfromzero.ACTION_FORCE_OFFLINE"));
            }
        });

        Func storeDataToFile = new Func(getString(R.string.stored_data_to_file), new Func.OnClickListener() {
            @Override
            public void action() {
                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = openFileOutput("test.txt", MODE_PRIVATE);
                    fileOutputStream.write("Hello World!".getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Closer.close(fileOutputStream);
                }
            }
        });

        Func read_data_from_file = new Func(getString(R.string.read_data_from_file), new Func.OnClickListener() {
            @Override
            public void action() {
                FileInputStream fileInputStream = null;
                BufferedReader fileReader = null;
                try {
                    fileInputStream = openFileInput("test.txt");
                    fileReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    String line;

                    while ((line = fileReader.readLine()) != null) {
                        Toast.makeText(AtyMain.this, line, Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Closer.close(fileInputStream);
                    Closer.close(fileReader);
                }
            }
        });

        Func storeDataToSP = new Func(getString(R.string.stored_data_to_sp), new Func.OnClickListener() {
            @Override
            public void action() {
                // name is current activity name
//                SharedPreferences sp = getPreferences(MODE_PRIVATE);
                // name is app's package name
//                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(AtyMain.this);
                SharedPreferences sp = getSharedPreferences("custom", MODE_PRIVATE);
//                sp.edit().putString("hello", "Hello World!").commit();
                sp.edit().putString("hello", "Hello World!").apply();
            }
        });

        Func readDataFromSP = new Func(getString(R.string.read_data_from_sp), new Func.OnClickListener() {
            @Override
            public void action() {
                SharedPreferences sp = getSharedPreferences("custom", MODE_PRIVATE);
                Toast.makeText(AtyMain.this, sp.getString("hello","default"), Toast.LENGTH_SHORT).show();

            }
        });

        Func useDataBase = new Func(getString(R.string.use_database), new Func.OnClickListener() {
            @Override
            public void action() {
                AtyUseDatabase.actionStart(AtyMain.this);
            }
        });

        funcs.add(easyStart);
        funcs.add(showAlert);
        funcs.add(showPBDialog);
        funcs.add(showCustomView);
        funcs.add(showListView);
        funcs.add(showFragment);
        funcs.add(showTableLayout);
        funcs.add(startReceiver);
        funcs.add(sendCustomBroadcast);
        funcs.add(sendLocalBroadcast);
        funcs.add(add_new_item);
        funcs.add(force_offline);
        funcs.add(storeDataToFile);
        funcs.add(read_data_from_file);
        funcs.add(storeDataToSP);
        funcs.add(readDataFromSP);
        funcs.add(useDataBase);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (recvNetChange != null) unregisterReceiver(recvNetChange);

        localManager.unregisterReceiver(recvLocal);
    }


    private void sendLocalBroadcast() {
        localManager.sendBroadcast(new Intent("com.lovexiaov.learnfromzero.ACTION_LOCAL_CUSTOM"));
    }

    private void registerNetChangeReceiver() {
        recvNetChange = new RecvNetChange();

        filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(recvNetChange, filter);
    }

    private void showFragmentAty() {
        Intent intent = new Intent(AtyMain.this, AtyFragment.class);
        startActivity(intent);
    }

    private void showListViewAty() {
        Intent intent = new Intent(AtyMain.this, AtyListView.class);
        startActivity(intent);
    }

    private void showCustomViewAty() {
        Intent intent = new Intent(AtyMain.this, AtyCustomView.class);
        startActivity(intent);
    }

    private void showTableLayoutAty() {
        Intent intent = new Intent(AtyMain.this, AtyTableLayout.class);
        startActivity(intent);
    }

    private void showProgressDialog() {
        ProgressDialog dialog = new ProgressDialog(AtyMain.this);
        dialog.setTitle("Progress Dialog");
        dialog.setMessage("Progress Dialog Message");
        dialog.setCancelable(true);
        dialog.show();
    }

    private void showAlert() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(AtyMain.this);
        dialog.setTitle("Alert");
//        dialog.setView(new Button(AtyMain.this));
        dialog.setMessage("This is an alert dialog");
        dialog.setPositiveButton("OK", null);
        dialog.setNegativeButton("Cancel", null);
        dialog.setNeutralButton("Neutral", null);
        dialog.show();

    }
}
