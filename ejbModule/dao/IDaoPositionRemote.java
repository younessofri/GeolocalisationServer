package dao;

import java.util.List;

import javax.ejb.Remote;

import entities.Position;


@Remote
public interface IDaoPositionRemote {
	boolean create(Position u);
	boolean delete (Position u);
	boolean update (Position u);
	Position getById(int id);
	List<Position> getByImei(String imei);
	List<Position> getAll();

}
