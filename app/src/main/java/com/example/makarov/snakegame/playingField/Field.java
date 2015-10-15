package com.example.makarov.snakegame.playingField;

import com.example.makarov.snakegame.exception.DuplicateObjectException;
import com.example.makarov.snakegame.exception.NotFoundObjectException;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
import java.util.Collection;
/**
 * Интерфес поля(карты игры)
 */
public interface Field {

    void addObject(FieldObject object, int x, int y) throws DuplicateObjectException;

    void changeObjectLocation(FieldObject object, int x, int y) throws NotFoundObjectException;

    void clearField();

    void removeObject(FieldObject object) throws NotFoundObjectException;

    Collection<FieldObject> getListObject();

    boolean isEmptyField(int x, int y);

    int getCodeFieldByPosition(int x, int y);

    int getWidth();

    int getHeight();

    int getCODE_ON_THE_MAP();
}
