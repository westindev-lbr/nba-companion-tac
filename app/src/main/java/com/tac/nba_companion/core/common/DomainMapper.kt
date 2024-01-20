package com.tac.nba_companion.core.common

interface DomainMapper<T, DomainEntity> {
    fun mapToDomainEntity(model: T): DomainEntity
}