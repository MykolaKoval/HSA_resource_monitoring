package com.course.hsa.repository;

import com.course.hsa.domain.TaskLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TaskLogRepository extends ElasticsearchRepository<TaskLog, String> {
}
