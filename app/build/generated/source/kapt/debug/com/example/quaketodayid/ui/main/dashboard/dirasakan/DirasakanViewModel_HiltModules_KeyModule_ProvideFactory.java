// Generated by Dagger (https://dagger.dev).
package com.example.quaketodayid.ui.main.dashboard.dirasakan;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DirasakanViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static DirasakanViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(DirasakanViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final DirasakanViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new DirasakanViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}