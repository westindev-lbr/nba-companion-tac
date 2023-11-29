package com.tac.nba_companion.domain.util

interface DomainMapper <T, DomainEntity>  {
    fun mapToDomainEntity(model: T): DomainEntity
    //fun mapFromDomainEntity(entityDomain: DomainEntity): T
}