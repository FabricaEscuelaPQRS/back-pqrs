package co.udea.ssmu.api.service.ssmuUser;

import co.udea.ssmu.api.model.dto.Archive;
import co.udea.ssmu.api.model.dto.User;
import co.udea.ssmu.api.model.entity.ArchiveE;

public interface ISsmuUser {

    public Archive createSsmuUser(Archive archive);
    public User deleteArchive(Long id);
    public Iterable<ArchiveE> listArchive();
    public Archive getArchiveById(Long id);

}
