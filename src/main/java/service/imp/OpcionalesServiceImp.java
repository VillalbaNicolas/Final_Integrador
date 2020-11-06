package service.imp;

import daos.OpcionalDAO;
import daos.imp.OpcionalDAOimp;
import dto.OpcionalesDTO;
import exception.DAOException;
import model.Opcional;
import service.OpcionalesService;



public class OpcionalesServiceImp implements OpcionalesService {


    private OpcionalDAO opcionalDAO = new OpcionalDAOimp();

    @Override
    public void ingresarOpcionales(OpcionalesDTO opcionalesDTO)throws DAOException {

        Opcional opcional = null;


        try {

            opcional = convertertoModel(opcionalesDTO);
            opcionalDAO.insert(opcional);

        }
        catch (Exception e) {
            System.out.println("serviceOpcional fallida");
            e.printStackTrace();
        }

    }

    @Override
    public OpcionalesDTO consultarOpcionales(Integer id)throws DAOException {
        OpcionalesDTO opcionalesDTO = null;
        try {


            opcionalesDTO = convertertoDTO(opcionalDAO.getQuery(id));


        }catch (Exception e) {
            System.out.println("serviceOpcional fallida");
            e.printStackTrace();
        }

        return opcionalesDTO;

    }

    @Override
    public void actualizarOpcionales(Integer id, OpcionalesDTO opcionalesDTO)throws DAOException {
        Opcional opcional = null;

        try {
            opcionalDAO.update(id, convertertoModel(opcionalesDTO));


        }catch (Exception e) {
            System.out.println("serviceOpcional fallida");
            e.printStackTrace();
        }

    }

    @Override
    public void borrarOpcionales(Integer id)throws DAOException {

        try {

            opcionalDAO.delete(id);


        }catch (Exception e) {
            System.out.println("serviceOpcional fallida");
            e.printStackTrace();
        }



    }



    public Opcional convertertoModel (OpcionalesDTO opcionalesDTO){

        Opcional opcional = new Opcional();

        opcional.setId(opcionalesDTO.getId());
        opcional.setPrecio(opcionalesDTO.getPrecio());
        opcional.setTipo(opcionalesDTO.getTipo());
        return opcional;
    }

    public OpcionalesDTO convertertoDTO (Opcional opcional){

        OpcionalesDTO opcionalesDTO = new OpcionalesDTO();

        opcionalesDTO.setId(opcional.getId());
        opcionalesDTO.setPrecio(opcional.getPrecio());
        opcionalesDTO.setTipo(opcional.getTipo());
        return opcionalesDTO;
    }
}

