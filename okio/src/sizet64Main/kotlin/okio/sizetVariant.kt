/*
 * Copyright (C) 2020 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package okio

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CPointer
import platform.posix.FILE
import platform.posix.fread
import platform.posix.fwrite

internal actual fun variantFread(
  target: CPointer<ByteVarOf<Byte>>,
  byteCount: UInt,
  file: CPointer<FILE>
): UInt {
  return fread(target, 1, byteCount.toULong(), file).toUInt()
}

internal actual fun variantFwrite(
  target: CPointer<ByteVar>,
  byteCount: UInt,
  file: CPointer<FILE>
): UInt {
  return fwrite(target, 1, byteCount.toULong(), file).toUInt()
}
