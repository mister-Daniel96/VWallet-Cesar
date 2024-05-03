package pe.edu.upc.vwalletweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.vwalletweb.entities.Menu;
import pe.edu.upc.vwalletweb.repositories.IMenuRepository;
import pe.edu.upc.vwalletweb.serviceinterfaces.IMenuService;

import java.util.List;

@Service
public class MenuServiceImplement implements IMenuService {
    @Autowired
    private IMenuRepository mR;

    @Override
    public void insert(Menu menu) {
        mR.save(menu);
    }

    @Override
    public List<Menu> list() {
        return mR.findAll();
    }

    @Override
    public void delete(int idMenu) {
        mR.deleteById(idMenu);
    }

    @Override
    public List<String[]> MenuDisponiblePorSede() {
        return mR.MenuDisponiblePorSede();
    }

    @Override
    public List<String[]> menusCaros() {
        return mR.menusCaros();
    }

    @Override
    public List<String[]> platosMasPedidos() { return mR.platosMasPedidos(); }

    @Override
    public List<String[]> menusEconomicos() { return mR.menusEconomicos(); }
}
