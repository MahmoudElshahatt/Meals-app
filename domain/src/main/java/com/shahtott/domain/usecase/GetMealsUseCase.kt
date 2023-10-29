package com.shahtott.domain.usecase

import com.shahtott.domain.repo.MealsRepository

class GetMealsUseCase(private val mealsRepository: MealsRepository) {
    suspend operator fun invoke() = mealsRepository.getMealsFromRemote()
}