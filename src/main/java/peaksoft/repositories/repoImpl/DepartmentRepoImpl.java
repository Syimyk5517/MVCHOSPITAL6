package peaksoft.repositories.repoImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.repositories.DepartmentRepo;


@RequiredArgsConstructor
@Repository
@Transactional
public class DepartmentRepoImpl implements DepartmentRepo {
}
