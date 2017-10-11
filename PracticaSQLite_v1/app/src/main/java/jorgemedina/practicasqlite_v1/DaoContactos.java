package jorgemedina.practicasqlite_v1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jlmgm on 09/10/2017.
 */

public class DaoContactos {

    private Context _contexto;
    private SQLiteDatabase _midb;


    //CREACION DE LA DB;
    public DaoContactos(Context contexto){

        this._contexto = contexto;
        this._midb = new MiDBOpenHelper(contexto).getWritableDatabase();

    }


    //INSERTAR DATOS;
    public long insert(Pojo_Contact c){

        ContentValues cv = new ContentValues();

        cv.put(MiDBOpenHelper.COLUMNS_CONTACTOS[1],c.getNombre());
        cv.put(MiDBOpenHelper.COLUMNS_CONTACTOS[2],c.getCorreo_electronico());
        cv.put(MiDBOpenHelper.COLUMNS_CONTACTOS[3],c.getTwitter());
        cv.put(MiDBOpenHelper.COLUMNS_CONTACTOS[4],c.getTelefono());
        cv.put(MiDBOpenHelper.COLUMNS_CONTACTOS[5],c.getFecha_nacimiento());

        return _midb.insert(MiDBOpenHelper.TABLE_CONTACTOS_NAME,null,cv) ;

    }


    //ACTUALIZAR DATOS;
    public long update(Pojo_Contact c){

        ContentValues cv = new ContentValues();

        cv.put(MiDBOpenHelper.COLUMNS_CONTACTOS[1],c.getNombre());
        cv.put(MiDBOpenHelper.COLUMNS_CONTACTOS[2],c.getCorreo_electronico());
        cv.put(MiDBOpenHelper.COLUMNS_CONTACTOS[3],c.getTwitter());
        cv.put(MiDBOpenHelper.COLUMNS_CONTACTOS[4],c.getTelefono());
        cv.put(MiDBOpenHelper.COLUMNS_CONTACTOS[5],c.getFecha_nacimiento());

        return _midb.update(MiDBOpenHelper.TABLE_CONTACTOS_NAME, cv, "_id=?", new String[] { String.valueOf( c.id)});

    }


    //ELIMINAR DATOS;
    public int delete(String id){

        return  _midb.delete("contactos","_id='"+id+"'",null);

    }


    //CREACION DE LISTA DATOS ORDENADOS;
    public List<Pojo_Contact> getAllStudentsList() {

        List<Pojo_Contact> studentsArrayList = new ArrayList<Pojo_Contact>();
        String selectQuery = "SELECT  * FROM " + "contactos";
        Log.d("", selectQuery);
        SQLiteDatabase db = this._midb;
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {

            do {

                Pojo_Contact students = new Pojo_Contact();
                students.id = c.getInt(c.getColumnIndex("_id"));
                students.nombre = c.getString(c.getColumnIndex("nombre"));
                students.correo_electronico = c.getString(c.getColumnIndex("correo_electronico"));
                students.twitter = c.getString(c.getColumnIndex("twitter"));
                students.telefono = c.getString(c.getColumnIndex("telefono"));
                students.fecha_nacimiento = c.getString(c.getColumnIndex("fecha_nacimiento"));
                studentsArrayList.add(students);

            } while (c.moveToNext());

        }

        return studentsArrayList;

    }



    //BUSQUEDA ORDENADOS POR EL NOMBRE;
    public List<Pojo_Contact> buscarcontacto(String name) {

        List<Pojo_Contact> studentsArrayList = new ArrayList<Pojo_Contact>();
        String selectQuery = "SELECT  * FROM contactos WHERE nombre LIKE '"+name+"%'";
        Log.d("", selectQuery);
        SQLiteDatabase db = this._midb;
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {

            do {

                Pojo_Contact students = new Pojo_Contact();
                students.id = c.getInt(c.getColumnIndex("_id"));
                students.nombre = c.getString(c.getColumnIndex("nombre"));
                students.correo_electronico = c.getString(c.getColumnIndex("correo_electronico"));
                students.twitter = c.getString(c.getColumnIndex("twitter"));
                students.telefono = c.getString(c.getColumnIndex("telefono"));
                students.fecha_nacimiento = c.getString(c.getColumnIndex("fecha_nacimiento"));
                studentsArrayList.add(students);

            } while (c.moveToNext());

        }

        return studentsArrayList;

    }



    //BUSQUEDA ORDENADOS POR EL ID;
    public ArrayList<Pojo_Contact> obtenercontacto(String id) {

        ArrayList<Pojo_Contact> studentsArrayList = new ArrayList<Pojo_Contact>();
        String selectQuery = "select * from contactos where _id='"+id+"'";
        Log.d("", selectQuery);
        SQLiteDatabase db = this._midb;
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {

            do {

                Pojo_Contact students = new Pojo_Contact();
                students.id = c.getInt(c.getColumnIndex("_id"));
                students.nombre = c.getString(c.getColumnIndex("nombre"));
                students.correo_electronico = c.getString(c.getColumnIndex("correo_electronico"));
                students.twitter = c.getString(c.getColumnIndex("twitter"));
                students.telefono = c.getString(c.getColumnIndex("telefono"));
                students.fecha_nacimiento = c.getString(c.getColumnIndex("fecha_nacimiento"));
                studentsArrayList.add(students);

            } while (c.moveToNext());

        }

        return studentsArrayList;

    }



}
