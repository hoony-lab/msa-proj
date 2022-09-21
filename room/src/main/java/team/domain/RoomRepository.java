package team.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import team.domain.*;

@RepositoryRestResource(collectionResourceRel = "rooms", path = "rooms")
public interface RoomRepository
    extends PagingAndSortingRepository<Room, Long> {}