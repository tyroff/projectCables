package org.itstep.vinokurov.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.itstep.vinokurov.domain.Brands;
import org.itstep.vinokurov.domain.CableBrand;
import org.itstep.vinokurov.domain.NominalCrossSection;
import org.itstep.vinokurov.domain.NumberOfConductor;
import org.itstep.vinokurov.domain.TnlaAndCableCategory;
import org.itstep.vinokurov.domain.TypeConductor;
import org.itstep.vinokurov.domain.RatedVoltage;
import org.itstep.vinokurov.logic.BrandsService;
import org.itstep.vinokurov.logic.BrandsServiceImpl;
import org.itstep.vinokurov.logic.CableBrandService;
import org.itstep.vinokurov.logic.CableBrandServiceImpl;
import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.CableCategoryServiceImpl;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.NominalCrossSectionService;
import org.itstep.vinokurov.logic.NominalCrossSectionServiceImpl;
import org.itstep.vinokurov.logic.NumberOfConductorService;
import org.itstep.vinokurov.logic.NumberOfConductorServiceImpl;
import org.itstep.vinokurov.logic.RatedVoltageService;
import org.itstep.vinokurov.logic.RatedVoltageServiceImpl;
import org.itstep.vinokurov.logic.TnlaAndCableCategoryService;
import org.itstep.vinokurov.logic.TnlaAndCableCategoryServiceImpl;
import org.itstep.vinokurov.logic.TnlaService;
import org.itstep.vinokurov.logic.TnlaServiceImpl;
import org.itstep.vinokurov.logic.TypeConductorService;
import org.itstep.vinokurov.logic.TypeConductorServiceImpl;
import org.itstep.vinokurov.logic.UserService;
import org.itstep.vinokurov.logic.UserServiceImpl;
import org.itstep.vinokurov.storage.BrandsDao;
import org.itstep.vinokurov.storage.CableBrandDao;
import org.itstep.vinokurov.storage.CableCategoryDao;
import org.itstep.vinokurov.storage.NominalCrossSectionDao;
import org.itstep.vinokurov.storage.NumberOfConductorDao;
import org.itstep.vinokurov.storage.RatedVoltageDao;
import org.itstep.vinokurov.storage.TnlaAndCableCategoryDao;
import org.itstep.vinokurov.storage.TnlaDao;
import org.itstep.vinokurov.storage.TypeConductorDao;
import org.itstep.vinokurov.storage.UserDao;
import org.itstep.vinokurov.storage.postgres.BrandsDbDaoImpl;
import org.itstep.vinokurov.storage.postgres.CableBrandDbDaoImpl;
import org.itstep.vinokurov.storage.postgres.CableCategoryDbDaoImpl;
import org.itstep.vinokurov.storage.postgres.NominalCrossSectionDbDaoImpl;
import org.itstep.vinokurov.storage.postgres.NumberOfConductorDbDaoImpl;
import org.itstep.vinokurov.storage.postgres.RatedVoltageDbDaoImpl;
import org.itstep.vinokurov.storage.postgres.TnlaAndCableCategoryDbDaoImpl;
import org.itstep.vinokurov.storage.postgres.TnlaDbDaoImpl;
import org.itstep.vinokurov.storage.postgres.TypeConductorDbDaoImpl;
import org.itstep.vinokurov.storage.postgres.UserDbDaoImpl;
import org.itstep.vinokurov.web.action.Action;
import org.itstep.vinokurov.web.action.MainAction;
import org.itstep.vinokurov.web.action.LoginAction;
import org.itstep.vinokurov.web.action.workspace.LogoutAction;
import org.itstep.vinokurov.web.action.workspace.WorkspaceAction;
import org.itstep.vinokurov.web.action.workspace.WorkspaceCableBrandsAddAction;
import org.itstep.vinokurov.web.action.workspace.WorkspaceCableBrandsSaveAction;
import org.itstep.vinokurov.web.action.workspace.brands.BrandsAction;
import org.itstep.vinokurov.web.action.workspace.brands.BrandsAddAction;
import org.itstep.vinokurov.web.action.workspace.brands.BrandsDelegateAction;
import org.itstep.vinokurov.web.action.workspace.brands.BrandsDeleteAction;
import org.itstep.vinokurov.web.action.workspace.brands.BrandsDeleteImplementAction;
import org.itstep.vinokurov.web.action.workspace.brands.BrandsSaveAction;
import org.itstep.vinokurov.web.action.workspace.brands.BrandsUpdateAction;
import org.itstep.vinokurov.web.action.workspace.cableCategory.CableCategoryAction;
import org.itstep.vinokurov.web.action.workspace.cableCategory.CableCategoryAddAction;
import org.itstep.vinokurov.web.action.workspace.cableCategory.CableCategoryDelegateAction;
import org.itstep.vinokurov.web.action.workspace.cableCategory.CableCategoryDeleteAction;
import org.itstep.vinokurov.web.action.workspace.cableCategory.CableCategoryDeleteImplementAction;
import org.itstep.vinokurov.web.action.workspace.cableCategory.CableCategorySaveAction;
import org.itstep.vinokurov.web.action.workspace.cableCategory.CableCategoryUpdateAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaAddAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaAndCableCategoryAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaAndCableCategorySaveAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaDelegateAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaDeleteAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaDeleteImplementAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaSaveAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaUpdateAction;

public class Factory implements AutoCloseable{
	
	private Map<String, ActionFactory> actions = new HashMap<>();
	{
		ActionFactory mainActionFactory = () -> getMainAction();
		actions.put("/index", mainActionFactory);
		actions.put("/login", () -> getLoginAction());
		actions.put("/logout", () -> getLogoutAction());
		
		actions.put("/workspace", () -> getWorkspaceAction());
		actions.put("/workspace/addCableBrands", () -> getWorkspaceCableBrandsAddAction());
		actions.put("/workspace/saveCableBrands", () -> getWorkspaceCableBrandsSaveAction());
	
		actions.put("/workspace/tnla", () -> getTnlaAction());
		actions.put("/workspace/tnla/delegate", () -> getTnlaDelegateAction());
		actions.put("/workspace/tnla/add", () -> getTnlaAddAction());
		actions.put("/workspace/tnla/save", () -> getTnlaSaveAction());
		actions.put("/workspace/tnla/update", () -> getTnlaUpdateAction());
		actions.put("/workspace/tnla/delete", () -> getTnlaDeleteAction());
		actions.put("/workspace/tnla/deleteImplement", () -> getTnlaDeleteImplementAction());
		actions.put("/workspace/tnla/tnlaAndCableCategory", () -> getTnlaAndCableCategoryAction());
		actions.put("/workspace/tnla/tnlaAndCableCategorySave", () -> getTnlaAndCableCategorySaveAction());		
		
		actions.put("/workspace/cableCategory", () -> getCableCategoryAction());
		actions.put("/workspace/cableCategory/delegate", () -> getCableCategoryDelegateAction());
		actions.put("/workspace/cableCategory/add", () -> getCableCategoryAddAction());
		actions.put("/workspace/cableCategory/save", () -> getCableCategorySaveAction());
		actions.put("/workspace/cableCategory/update", () -> getCableCategoryUpdateAction());
		actions.put("/workspace/cableCategory/delete", () -> getCableCategoryDeleteAction());
		actions.put("/workspace/cableCategory/deleteImplement", () -> getCableCategoryDeleteImplementAction());
		
		actions.put("/workspace/brands", () -> getBrandsAction());
		actions.put("/workspace/brands/delegate", () -> getBrandsDelegateAction());
		actions.put("/workspace/brands/add", () -> getBrandsAddAction());
		actions.put("/workspace/brands/save", () -> getBrandsSaveAction());
		actions.put("/workspace/brands/update", () -> getBrandsUpdateAction());
		actions.put("/workspace/brands/delete", () -> getBrandsDeleteAction());
		actions.put("/workspace/brands/deleteImplement", () -> getBrandsDeleteImplementAction());
	}
	
	public Action getAction(String url) throws LogicException {
		ActionFactory factory = actions.get(url);
		if(factory != null) {
			return factory.getInstance();
		}
		return null;
	}
	
	private Action mainAction = null;
	public Action getMainAction() {
		if(mainAction == null) {
			mainAction = new MainAction();
		}
		return mainAction;
	}
	
	private Action loginAction = null;
	public Action getLoginAction() throws LogicException{
		if(loginAction == null) {
			LoginAction loginActionImpl = new LoginAction();
			loginAction = loginActionImpl;
			loginActionImpl.setUserService(getUserService());
		}
		return loginAction;
	}
	
	private Action logoutAction = null;
	public Action getLogoutAction() throws LogicException {
		if(logoutAction == null) {
			logoutAction = new LogoutAction();
		}
		return logoutAction;
	}
//Workspace------------------------------------------------------------------------------------------------------------	
	private Action workspaceAction = null;
	public Action getWorkspaceAction() throws LogicException {
		if(workspaceAction == null) {
			WorkspaceAction workspaceActionImpl = new WorkspaceAction();
			workspaceAction = workspaceActionImpl;
			workspaceActionImpl.setTnlaService(getTnlaService());
			workspaceActionImpl.setCableCategoryService(getCableCategoryService());
			workspaceActionImpl.setTnlaAndCableCategoryService(getTnlaAndCableCategoryService());
			workspaceActionImpl.setBrandsService(getBrandsService());
			workspaceActionImpl.setNumberOfConductorService(getNumberOfConductorService());
			workspaceActionImpl.setNominalCrossSectionService(getNominalCrossSectionService());
			workspaceActionImpl.setTypeConductorService(getTypeConductorService());
			workspaceActionImpl.setRatedVoltageService(getRatedVoltageService());
			workspaceActionImpl.setCableBrandService(getCableBrandService());
		}
		return workspaceAction;
	}
	
	private Action workspaceCableBrandsAddAction = null;
	public Action getWorkspaceCableBrandsAddAction() throws LogicException {
		if(workspaceCableBrandsAddAction == null) {
			WorkspaceCableBrandsAddAction workspaceAddCableBrandsActionImpl = new WorkspaceCableBrandsAddAction();
			workspaceCableBrandsAddAction = workspaceAddCableBrandsActionImpl;
			workspaceAddCableBrandsActionImpl.setTnlaService(getTnlaService());
			workspaceAddCableBrandsActionImpl.setCableCategoryService(getCableCategoryService());
			workspaceAddCableBrandsActionImpl.setBrandsService(getBrandsService());
			workspaceAddCableBrandsActionImpl.setNumberOfConductorService(getNumberOfConductorService());
			workspaceAddCableBrandsActionImpl.setNominalCrossSectionService(getNominalCrossSectionService());
			workspaceAddCableBrandsActionImpl.setTypeConductorService(getTypeConductorService());
			workspaceAddCableBrandsActionImpl.setRatedVoltageService(getRatedVoltageService());
		}
		return workspaceCableBrandsAddAction;
	}
	
	private Action workspaceCableBrandsSaveAction = null;
	public Action getWorkspaceCableBrandsSaveAction() throws LogicException {
		if(workspaceCableBrandsSaveAction == null) {
			WorkspaceCableBrandsSaveAction workspaceCableBrandsSaveActionImpl = new WorkspaceCableBrandsSaveAction();
			workspaceCableBrandsSaveAction = workspaceCableBrandsSaveActionImpl;
			workspaceCableBrandsSaveActionImpl.setCableBrandService(getCableBrandService());
		}
		return workspaceCableBrandsSaveAction;
	}
//TNLA------------------------------------------------------------------------------------------------------------	
	private Action tnlaAction = null;
	public Action getTnlaAction() throws LogicException {
		if(tnlaAction == null) {
			TnlaAction tnlaActionImpl = new TnlaAction();
			tnlaAction = tnlaActionImpl;
			tnlaActionImpl.setTnlaService(getTnlaService());
		}
		return tnlaAction;
	}	
	
	private Action tnlaDelegateAction = null;
	public Action getTnlaDelegateAction() {
		if(tnlaDelegateAction == null) {
			tnlaDelegateAction = new TnlaDelegateAction();
		}
		return tnlaDelegateAction;
	}

	private Action tnlaAddAction = null;
	public Action getTnlaAddAction() throws LogicException {
		if(tnlaAddAction == null) {
			TnlaAddAction tnlaAddActionImpl = new TnlaAddAction();
			tnlaAddAction = tnlaAddActionImpl;
		}
		return tnlaAddAction;
	}	
	
	private Action tnlaSaveAction = null;
	public Action getTnlaSaveAction() throws LogicException {
		if(tnlaSaveAction == null) {
			TnlaSaveAction tnlaSaveActionImpl = new TnlaSaveAction();
			tnlaSaveAction = tnlaSaveActionImpl;
			tnlaSaveActionImpl.setTnlaService(getTnlaService());
		}
		return tnlaSaveAction;
	}
	
	private Action tnlaUpdateAction = null;
	public Action getTnlaUpdateAction() throws LogicException {
		if(tnlaUpdateAction == null) {
			TnlaUpdateAction tnlaUpdateActionImpl = new TnlaUpdateAction();
			tnlaUpdateAction = tnlaUpdateActionImpl;
			tnlaUpdateActionImpl.setTnlaService(getTnlaService());
		}
		return tnlaUpdateAction;
	}
	
	private Action tnlaDeleteAction = null;
	public Action getTnlaDeleteAction() throws LogicException {
		if(tnlaDeleteAction == null) {
			TnlaDeleteAction tnlaDeleteActionImpl = new TnlaDeleteAction();
			tnlaDeleteAction = tnlaDeleteActionImpl;
			tnlaDeleteActionImpl.setTnlaService(getTnlaService());
		}
		return tnlaDeleteAction;
	}
	
	private Action tnlaDeleteImplementAction = null;
	public Action getTnlaDeleteImplementAction() throws LogicException {
		if(tnlaDeleteImplementAction == null) {
			TnlaDeleteImplementAction tnlaDeleteImplementActionImpl = new TnlaDeleteImplementAction();
			tnlaDeleteImplementAction = tnlaDeleteImplementActionImpl;
			tnlaDeleteImplementActionImpl.setTnlaService(getTnlaService());
		}
		return tnlaDeleteImplementAction;
	}
//TnlaAndCableCategory------------------------------------------------------------------------------------------	
	private Action tnlaAndCableCategoryAction = null;
	public Action getTnlaAndCableCategoryAction() throws LogicException {
		if(tnlaAndCableCategoryAction == null) {
			TnlaAndCableCategoryAction tnlaAndCableCategoryActionImpl = new TnlaAndCableCategoryAction();
			tnlaAndCableCategoryAction = tnlaAndCableCategoryActionImpl;
			tnlaAndCableCategoryActionImpl.setTnlaService(getTnlaService());
			tnlaAndCableCategoryActionImpl.setCableCategoryService(getCableCategoryService());
			tnlaAndCableCategoryActionImpl.setTnlaAndCableCategoryService(getTnlaAndCableCategoryService());
		}
		return tnlaAndCableCategoryAction;
	}
	
	private Action tnlaAndCableCategorySaveAction = null;
	public Action getTnlaAndCableCategorySaveAction() throws LogicException {
		if(tnlaAndCableCategorySaveAction == null) {
			TnlaAndCableCategorySaveAction tnlaAndCableCategorySaveActionImpl = new TnlaAndCableCategorySaveAction();
			tnlaAndCableCategorySaveAction = tnlaAndCableCategorySaveActionImpl;
			tnlaAndCableCategorySaveActionImpl.setTnlaAndCableCategoryService(getTnlaAndCableCategoryService());
		}
		return tnlaAndCableCategorySaveAction;
	}
//CableCategory--------------------------------------------------------------------------------------------------
	private Action cableCategoryAction = null;
	public Action getCableCategoryAction() throws LogicException {
		if(cableCategoryAction == null) {
			CableCategoryAction cableCategoryActionImpl = new CableCategoryAction();
			cableCategoryAction = cableCategoryActionImpl;
			cableCategoryActionImpl.setCableCategoryService(getCableCategoryService());
		}
		return cableCategoryAction;
	}	
	
	private Action cableCategoryDelegateAction = null;
	public Action getCableCategoryDelegateAction() {
		if(cableCategoryDelegateAction == null) {
			cableCategoryDelegateAction = new CableCategoryDelegateAction();
		}
		return cableCategoryDelegateAction;
	}

	private Action cableCategoryAddAction = null;
	public Action getCableCategoryAddAction() throws LogicException {
		if(cableCategoryAddAction == null) {
			CableCategoryAddAction cableCategoryAddActionImpl = new CableCategoryAddAction();
			cableCategoryAddAction = cableCategoryAddActionImpl;
		}
		return cableCategoryAddAction;
	}	
	
	private Action cableCategorySaveAction = null;
	public Action getCableCategorySaveAction() throws LogicException {
		if(cableCategorySaveAction == null) {
			CableCategorySaveAction cableCategorySaveActionImpl = new CableCategorySaveAction();
			cableCategorySaveAction = cableCategorySaveActionImpl;
			cableCategorySaveActionImpl.setCableCategoryService(getCableCategoryService());
		}
		return cableCategorySaveAction;
	}
	
	private Action cableCategoryUpdateAction = null;
	public Action getCableCategoryUpdateAction() throws LogicException {
		if(cableCategoryUpdateAction == null) {
			CableCategoryUpdateAction cableCategoryUpdateActionImpl = new CableCategoryUpdateAction();
			cableCategoryUpdateAction = cableCategoryUpdateActionImpl;
			cableCategoryUpdateActionImpl.setCableCategoryService(getCableCategoryService());
		}
		return cableCategoryUpdateAction;
	}
	
	private Action cableCategoryDeleteAction = null;
	public Action getCableCategoryDeleteAction() throws LogicException {
		if(cableCategoryDeleteAction == null) {
			CableCategoryDeleteAction cableCategoryDeleteActionImpl = new CableCategoryDeleteAction();
			cableCategoryDeleteAction = cableCategoryDeleteActionImpl;
			cableCategoryDeleteActionImpl.setCableCategoryService(getCableCategoryService());
		}
		return cableCategoryDeleteAction;
	}
	
	private Action cableCategoryDeleteImplementAction = null;
	public Action getCableCategoryDeleteImplementAction() throws LogicException {
		if(cableCategoryDeleteImplementAction == null) {
			CableCategoryDeleteImplementAction cableCategoryDeleteImplementActionImpl = new CableCategoryDeleteImplementAction();
			cableCategoryDeleteImplementAction = cableCategoryDeleteImplementActionImpl;
			cableCategoryDeleteImplementActionImpl.setCableCategoryService(getCableCategoryService());
		}
		return cableCategoryDeleteImplementAction;
	}
//Brands------------------------------------------------------------------------------------------------------------
	private Action brandsAction = null;
	public Action getBrandsAction() throws LogicException {
		if(brandsAction == null) {
			BrandsAction brandsActionImpl = new BrandsAction();
			brandsAction = brandsActionImpl;
			brandsActionImpl.setBrandsService(getBrandsService());
		}
		return brandsAction;
	}	
	
	private Action brandsDelegateAction = null;
	public Action getBrandsDelegateAction() {
		if(brandsDelegateAction == null) {
			brandsDelegateAction = new BrandsDelegateAction();
		}
		return brandsDelegateAction;
	}

	private Action brandsAddAction = null;
	public Action getBrandsAddAction() throws LogicException {
		if(brandsAddAction == null) {
			BrandsAddAction brandsAddActionImpl = new BrandsAddAction();
			brandsAddAction = brandsAddActionImpl;
		}
		return brandsAddAction;
	}	
	
	private Action brandsSaveAction = null;
	public Action getBrandsSaveAction() throws LogicException {
		if(brandsSaveAction == null) {
			BrandsSaveAction brandsSaveActionImpl = new BrandsSaveAction();
			brandsSaveAction = brandsSaveActionImpl;
			brandsSaveActionImpl.setBrandsService(getBrandsService());
		}
		return brandsSaveAction;
	}
	
	private Action brandsUpdateAction = null;
	public Action getBrandsUpdateAction() throws LogicException {
		if(brandsUpdateAction == null) {
			BrandsUpdateAction brandsUpdateActionImpl = new BrandsUpdateAction();
			brandsUpdateAction = brandsUpdateActionImpl;
			brandsUpdateActionImpl.setBrandsService(getBrandsService());
		}
		return brandsUpdateAction;
	}
	
	private Action brandsDeleteAction = null;
	public Action getBrandsDeleteAction() throws LogicException {
		if(brandsDeleteAction == null) {
			BrandsDeleteAction brandsDeleteActionImpl = new BrandsDeleteAction();
			brandsDeleteAction = brandsDeleteActionImpl;
			brandsDeleteActionImpl.setBrandsService(getBrandsService());
		}
		return brandsDeleteAction;
	}
	
	private Action brandsDeleteImplementAction = null;
	public Action getBrandsDeleteImplementAction() throws LogicException {
		if(brandsDeleteImplementAction == null) {
			BrandsDeleteImplementAction brandsDeleteImplementActionImpl = new BrandsDeleteImplementAction();
			brandsDeleteImplementAction = brandsDeleteImplementActionImpl;
			brandsDeleteImplementActionImpl.setBrandsService(getBrandsService());
		}
		return brandsDeleteImplementAction;
	}
//Service------------------------------------------------------------------------------------------------------------	
	private TnlaService tnlaService = null;
	public TnlaService getTnlaService() throws LogicException {
		if(tnlaService == null) {
			TnlaServiceImpl service = new TnlaServiceImpl();
			tnlaService = service;
			service.setTnlaDao(getTnlaDao());
		}
		return tnlaService;
	}
	
	private CableCategoryService cableCategoryService = null;
	public CableCategoryService getCableCategoryService() throws LogicException {
		if(cableCategoryService == null) {
			CableCategoryServiceImpl service = new CableCategoryServiceImpl();
			cableCategoryService = service;
			service.setCableCategoryDao(getCableCategoryDao());
		}
		return cableCategoryService;
	}

	private CableBrandService<CableBrand, Long> cableBrandService = null;
	public CableBrandService<CableBrand, Long> getCableBrandService() throws LogicException {
		if(cableBrandService == null) {
			CableBrandServiceImpl service = new CableBrandServiceImpl();
			cableBrandService = service;
			service.setCableBrandDao(getCableBrandDao());
		}
		return cableBrandService;
	}
	
	private BrandsService<Brands, Long> brandsService = null;
	public BrandsService<Brands, Long> getBrandsService() throws LogicException {
		if(brandsService == null) {
			BrandsServiceImpl service = new BrandsServiceImpl();
			brandsService = service;
			service.setBrandsDao(getBrandsDao());
		}
		return brandsService;
	}
	
	private NumberOfConductorService<NumberOfConductor, Long> numberOfConductorService = null;
	public NumberOfConductorService<NumberOfConductor, Long> getNumberOfConductorService() throws LogicException {
		if(numberOfConductorService == null) {
			NumberOfConductorServiceImpl service = new NumberOfConductorServiceImpl();
			numberOfConductorService = service;
			service.setNumberOfConductorDao(getNumberOfConductorDao() );
		}
		return numberOfConductorService;
	}

	private NominalCrossSectionService<NominalCrossSection, Long> nominalCrossSectionService = null;
	public NominalCrossSectionService<NominalCrossSection, Long> getNominalCrossSectionService() throws LogicException {
		if(nominalCrossSectionService == null) {
			NominalCrossSectionServiceImpl service = new NominalCrossSectionServiceImpl();
			nominalCrossSectionService = service;
			service.setNominalCrossSectionDao(getNominalCrossSectionDao() );
		}
		return nominalCrossSectionService;
	}
	
	private TypeConductorService<TypeConductor, Long> typeConductorService = null;
	public TypeConductorService<TypeConductor, Long> getTypeConductorService() throws LogicException {
		if(typeConductorService == null) {
			TypeConductorServiceImpl service = new TypeConductorServiceImpl();
			typeConductorService = service;
			service.setTypeConductorDao(getTypeConductorDao() );
		}
		return typeConductorService;
	}

	private RatedVoltageService<RatedVoltage, Long> ratedVoltageService = null;
	public RatedVoltageService<RatedVoltage, Long> getRatedVoltageService() throws LogicException {
		if(ratedVoltageService == null) {
			RatedVoltageServiceImpl service = new RatedVoltageServiceImpl();
			ratedVoltageService = service;
			service.setRatedVoltageDao(getRatedVoltageDao() );
		}
		return ratedVoltageService;
	}
	
	private TnlaAndCableCategoryService<TnlaAndCableCategory, Long> tnlaAndCableCategoryService = null;
	public TnlaAndCableCategoryService<TnlaAndCableCategory, Long> getTnlaAndCableCategoryService() throws LogicException {
		if(tnlaAndCableCategoryService == null) {
			TnlaAndCableCategoryServiceImpl service = new TnlaAndCableCategoryServiceImpl();
			tnlaAndCableCategoryService = service;
			service.setTnlaAndCableCategoryDao(getTnlaAndCableCategoryDao());
		}
		return tnlaAndCableCategoryService;
	}
	
	private UserService userService = null;
	public UserService getUserService() throws LogicException {
		if(userService == null) {
			UserServiceImpl service = new UserServiceImpl();
			userService = service;
			service.setUserDao(getUserDao());
		}
		return userService;
	}
//Dao--------------------------------------------------------------------------------------------------------	
	private TnlaDao tnlaDao = null;
	public TnlaDao getTnlaDao() throws LogicException{
		if(tnlaDao == null) {
			TnlaDbDaoImpl tnlaDbDaoImpl = new TnlaDbDaoImpl();
			tnlaDao = tnlaDbDaoImpl;
			tnlaDbDaoImpl.setConnection(getConnection());
		}
		return tnlaDao;
	}
	
	private CableCategoryDao cableCategoryDao = null;
	public CableCategoryDao getCableCategoryDao() throws LogicException{
		if(cableCategoryDao == null) {
			CableCategoryDbDaoImpl cableCategoryDbDaoImpl = new CableCategoryDbDaoImpl();
			cableCategoryDao = cableCategoryDbDaoImpl;
			cableCategoryDbDaoImpl.setConnection(getConnection());
		}
		return cableCategoryDao;
	}

	private TnlaAndCableCategoryDao<TnlaAndCableCategory, Long> tnlaAndCableCategoryDao = null;
	public TnlaAndCableCategoryDao<TnlaAndCableCategory, Long> getTnlaAndCableCategoryDao() throws LogicException{
		if(tnlaAndCableCategoryDao == null) {
			TnlaAndCableCategoryDbDaoImpl tnlaAndCableCategoryDbDaoImpl = new TnlaAndCableCategoryDbDaoImpl();
			tnlaAndCableCategoryDao = tnlaAndCableCategoryDbDaoImpl;
			tnlaAndCableCategoryDbDaoImpl.setConnection(getConnection());
		}
		return tnlaAndCableCategoryDao;
	}
	
	private BrandsDao<Brands, Long> brandsDao = null;
	public BrandsDao<Brands, Long> getBrandsDao() throws LogicException{
		if(brandsDao == null) {
			BrandsDbDaoImpl brandsDbDaoImpl = new BrandsDbDaoImpl();
			brandsDao = brandsDbDaoImpl;
			brandsDbDaoImpl.setConnection(getConnection());
		}
		return brandsDao;
	}
	
	private NumberOfConductorDao<NumberOfConductor, Long> numberOfConductorDao = null;
	public NumberOfConductorDao<NumberOfConductor, Long> getNumberOfConductorDao() throws LogicException{
		if(numberOfConductorDao == null) {
			NumberOfConductorDbDaoImpl numberOfConductorDbDaoImpl = new NumberOfConductorDbDaoImpl();
			numberOfConductorDao = numberOfConductorDbDaoImpl;
			numberOfConductorDbDaoImpl.setConnection(getConnection());
		}
		return numberOfConductorDao;
	}
	
	private NominalCrossSectionDao<NominalCrossSection, Long> nominalCrossSectionDao = null;
	public NominalCrossSectionDao<NominalCrossSection, Long> getNominalCrossSectionDao() throws LogicException{
		if(nominalCrossSectionDao == null) {
			NominalCrossSectionDbDaoImpl nominalCrossSectionDbDaoImpl = new NominalCrossSectionDbDaoImpl();
			nominalCrossSectionDao = nominalCrossSectionDbDaoImpl;
			nominalCrossSectionDbDaoImpl.setConnection(getConnection());
		}
		return nominalCrossSectionDao;
	}
	
	private TypeConductorDao<TypeConductor, Long> typeConductorDao = null;
	public TypeConductorDao<TypeConductor, Long> getTypeConductorDao() throws LogicException{
		if(typeConductorDao == null) {
			TypeConductorDbDaoImpl typeConductorDbDaoImpl = new TypeConductorDbDaoImpl();
			typeConductorDao = typeConductorDbDaoImpl;
			typeConductorDbDaoImpl.setConnection(getConnection());
		}
		return typeConductorDao;
	}

	private RatedVoltageDao<RatedVoltage, Long> ratedVoltageDao = null;
	public RatedVoltageDao<RatedVoltage, Long> getRatedVoltageDao() throws LogicException{
		if(ratedVoltageDao == null) {
			RatedVoltageDbDaoImpl ratedVoltageDbDaoImpl = new RatedVoltageDbDaoImpl();
			ratedVoltageDao = ratedVoltageDbDaoImpl;
			ratedVoltageDbDaoImpl.setConnection(getConnection());
		}
		return ratedVoltageDao;
	}	
	
	private CableBrandDao<CableBrand, Long> cableBrandDao = null;
	public CableBrandDao<CableBrand, Long> getCableBrandDao() throws LogicException{
		if(cableBrandDao == null) {
			CableBrandDbDaoImpl cableBrandDbDaoImpl = new CableBrandDbDaoImpl();
			cableBrandDao = cableBrandDbDaoImpl;
			cableBrandDbDaoImpl.setConnection(getConnection());
		}
		return cableBrandDao;
	}
	
	private UserDao userDao = null;
	public UserDao getUserDao() throws LogicException{
		if(userDao == null) {
			UserDbDaoImpl userDbDaoImpl = new UserDbDaoImpl();
			userDao = userDbDaoImpl;
			userDbDaoImpl.setConnection(getConnection());
		}
		return userDao;
	}

	private Connection connection = null;
	public Connection getConnection() throws LogicException {
		if(connection == null) {
			try {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost/cables", "root", "hello");
			} catch(SQLException e) {
				throw new LogicException(e);
			}
		}
		return connection;
	}

	@Override
	public void close(){
		try {
			connection.close();
		} catch(Exception e) {}
	}
	
	private static interface ActionFactory {
		Action getInstance() throws LogicException;
	}
}
