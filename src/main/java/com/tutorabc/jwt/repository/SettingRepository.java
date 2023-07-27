package com.tutorabc.jwt.repository;

import com.tutorabc.jwt.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {

    Setting findBySettingKey(String settingKey);
}
