package untitled.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

@RepositoryRestResource(collectionResourceRel = "viewPages", path = "viewPages")
public interface ViewPageRepository
    extends PagingAndSortingRepository<ViewPage, Long> {}
